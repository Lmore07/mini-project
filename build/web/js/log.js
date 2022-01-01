var repetidas = null;
var num_p;
var myObj = new Object;
var contador = 0;
var puntaje = 0;

$("#btn1").click(() => hace_preguntas("btn1"));
$("#btn2").click(() => hace_preguntas("btn2"));
$("#btn3").click(() => hace_preguntas("btn3"));
$("#btn4").click(() => hace_preguntas("btn4"));
$("#btn5").click(() => hace_preguntas("btn5"));
$("#btn6").click(() => hace_preguntas("btn6"));
$("#btn7").click(() => hace_preguntas("btn7"));
$("#btn8").click(() => hace_preguntas("btn8"));
$("#btn9").click(() => hace_preguntas("btn9"));
$("#btn10").click(() => hace_preguntas("btn10"));
$("#btn11").click(() => hace_preguntas("btn11"));
$("#btn12").click(() => hace_preguntas("btn12"));

function hace_preguntas(btn) {
    if (contador !== 12) {
        generar_preg_aleatoria();
        $.ajax({
            type: 'POST',
            url: '/mini-project/preguntas',
            data: {"preg": num_p},
            beforeSend: function (xhr) {
                console.log("procesando");
            },
            success: function (data) {
                let response = JSON.parse(data);
                if (response["status"] === 2) {
                    Swal
                            .fire({
                                title: response["pregunta"],
                                input: "text",
                                showCancelButton: false,
                                confirmButtonText: "Guardar",
                                cancelButtonText: "Cancelar",
                                inputValidator: rpta => {
                                    // Si el valor es válido, debes regresar undefined. Si no, una cadena
                                    if (!rpta) {
                                        return "Por favor responde la pregunta";
                                    } else {
                                        return undefined;
                                    }
                                }
                            })
                            .then(resultado => {
                                if (resultado.value) {
                                    let rpta = resultado.value.toString();
                                    var opciones = response["respuesta"].toString().split('/');
                                    $('#' + btn).removeClass('btn btn-outline-danger');
                                    var bo = false;
                                    for (const x in opciones) {
                                        if (rpta.trimEnd().trimStart().localeCompare(opciones[x].toString(), undefined, {sensitivity: 'base'}) == 0) {
                                            bo = true;
                                            break;
                                        }
                                    }
                                    if (bo) {
                                        $('#' + btn).addClass('btn btn-success');
                                        puntaje++;
                                        mensaje_bien();
                                    } else {
                                        $('#' + btn).addClass('btn btn-danger');
                                        mensaje_incorrecto(opciones[0]);
                                    }
                                    $(document).ready(function () {
                                        $("#" + btn).prop('disabled', true);
                                    });

                                    contador++;
                                    if (contador === 12) {
                                        var puntoss=calc_puntaje();
                                        $.ajax({
                                            type: 'POST',
                                            url: "/mini-project/puntajes",
                                            data: {"puntos":puntoss},
                                            beforeSend: function () {
                                                console.log("procesando puntos");
                                            },
                                            success: function (data) {
                                                console.log("PUNTAJE GUARDADO");
                                            },
                                            error: function (jqXHR, textStatus, errorThrown) {
                                                console.log(textStatus);
                                            }
                                        });
                                        Swal.fire({
                                            title: 'TU PUNTUACION ES: ' +puntoss + ' PUNTOS',
                                            width: 600,
                                            padding: '3em',
                                            color: '#716add',
                                            backdrop: `
                              rgba(0,0,123,0.4)
                              url("../imagenes/baile.gif")
                              left top
                              no-repeat
                            `
                                        })
                                    }
                                } else {
                                    delete repetidas[num_p.toString()];
                                    hace_preguntas(btn);
                                }
                            });
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    }
}

function ver_repetidas(preg) {
    for (const x in repetidas) {
        if (repetidas[x] == preg) {
            return true;
        }
    }
    return false;
}

function calc_puntaje() {
    var total = Math.round((puntaje * 100) / 12, 2);
    return total.toString();
}

function generar_preg_aleatoria() {
    while (true) {
        var rnd = Math.ceil(Math.random() * (30 - 0) + 0);
        if (repetidas === null) {
            num_p = rnd.toString();
            myObj[num_p] = rnd;
            repetidas = Object.assign(myObj, repetidas);
            break;
        } else if (ver_repetidas(rnd) === false) {
            num_p = rnd.toString();
            myObj[num_p] = rnd;
            repetidas = Object.assign(repetidas, myObj);
            break;
        }
    }
    return rnd;
}

function mensaje_bien() {
    let timerInterval
    Swal.fire({
        title: 'Excelente has acertado',
        timer: 2000,
        icon: 'success',
        showConfirmButton: false,
        timerProgressBar: true,
        didOpen: () => {
            //Swal.showLoading()
            const b = Swal.getHtmlContainer().querySelector('b')
            timerInterval = setInterval(() => {
                //b.textContent = Swal.getTimerLeft()
            }, 100)
        },
        willClose: () => {
            clearInterval(timerInterval)
        }
    }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {
            console.log('I was closed by the timer')
        }
    })
}

function mensaje_incorrecto(correcta) {
    let timerInterval
    Swal.fire({
        title: 'Opps respuesta incorrecta',
        html: 'La respuesta correcta es: ' + correcta + '',
        timer: 2000,
        icon: 'error',
        showConfirmButton: false,
        timerProgressBar: true,
        didOpen: () => {
            //Swal.showLoading()
            const b = Swal.getHtmlContainer().querySelector('b')
            timerInterval = setInterval(() => {
                //b.textContent = Swal.getTimerLeft()
            }, 100)
        },
        willClose: () => {
            clearInterval(timerInterval)
        }
    }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {
            console.log('I was closed by the timer')
        }
    })
}