let dataCalendario = new Date();
let dataSelecionada = new Date();
let novaAtividade = 0;

initialize();

function initialize(){
    desativarLinks();
    createCalendar(dataCalendario);

    bindNextMonthButton();
    bindPreviousMonthButton();
    bindModalButton();
    bindSalvarAtividadeButton();
    limpaModal();
}

function bindNextMonthButton() {
    $("#next-month").unbind().click(function(){
        atualizaCalendario(1);
    });
}

function bindPreviousMonthButton() {
    $("#previous-month").unbind().click(function(){
        atualizaCalendario(-1);
    });
}

function bindModalButton() {
    $("#addAtividade").unbind().click(function(){
        $("#modalAtividade").modal('show');
        $('#modalLabel').text('Cadastrar Atividade');
    });
}

function bindSalvarAtividadeButton() {
    $("#salvarAtividade").unbind().click(function(){
        let talhao = $('#talhoes option').filter(function() {
                        return $(this).text() === $('#talhao').val();
                     }).data('value');
        let cultura = $('#culturas option').filter(function() {
                        return $(this).text() === $('#cultura').val();
                     }).data('value');
        let maoObra = $("#maoObra").val();
        let receita = $("#receita").val();
        let descricao = $("#descricao").val();
        let dia = dataSelecionada.getDate() < 10 ? ('0'+dataSelecionada.getDate()) : dataSelecionada.getDate();
        let mes = (dataSelecionada.getMonth()+1) < 10 ? ('0'+(dataSelecionada.getMonth()+1)) : (dataSelecionada.getMonth()+1);
        let ano = dataSelecionada.getFullYear();
        let data = ano+'-'+mes+'-'+dia;
        let id = $("#idAtividade").val();

        $.ajax({
            url: "/cadAtividade",
            method: "POST",
            data:{
                id: id,
                talhao: talhao,
                cultura: cultura,
                maoObra: maoObra,
                receita: receita,
                descricao: descricao,
                data: data
            },
            success: function(data){
                novaAtividade++;
                if(data.sucesso){
                    $("#semAtividade").remove();
                    $("#modalAtividade").modal('hide');
                    toastAlert("success",data.mensagem);
                    atualizaDataAtividades();
                }else{
                    toastAlert("error",data.mensagem);
                }
            },
            error: function(){
                toastAlert("error","Erro ao salvar a atividade.");
            }
        });
    });
}

function atualizaCalendario(att){
    dataCalendario.setMonth(dataCalendario.getMonth()+(att));
    createCalendar(dataCalendario);
}

function createCalendar(data){
    data.setHours(0,0,0,0);
    dataSelecionada.setHours(0,0,0,0);

    let dataAtual = new Date();
    dataAtual.setHours(0,0,0,0);

    let dataInicio = new Date(data);
    dataInicio.setDate(1);
    if(dataInicio.getDay() !== 0){
        dataInicio.setDate((dataInicio.getDay() * -1)+1);
    }

    let dataFim = new Date(data.getFullYear(),data.getMonth()+1,0);

    if(dataFim.getDay() !== 6){
        dataFim.setDate(dataFim.getDate() + (6 - dataFim.getDay()));
    }

    imprimeCabecalhoCalendario(data);
    imprimeDatasCalendario(new Date(dataInicio),dataFim,data);

    atualizaDataAtividades();
    ativarClickCalendario();
}

function imprimeCabecalhoCalendario(data){
    const nomeMeses = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho",
                                "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];

    $("#mes").text(nomeMeses[data.getMonth()]);
    $("#ano").text(data.getFullYear());
}

function imprimeDatasCalendario(dataAux,dataFim,data){
    $("tbody").text("");
    let linha = 0;
    let count = 0;
    let classe = "";

    dataAux.setHours(0,0,0,0);
    while(dataAux <= dataFim){
        if(count % 7 == 0){
            linha++;
            $('tbody').append('<tr id="linha'+linha+'"></tr>');
        }

        if(dataAux.getMonth() !== data.getMonth()){
            classe = ' class="outro-mes" ';
        }else if(dataAux.getTime() == dataSelecionada.getTime()){
            classe = ' class="dia-ativo" ';
        }else{
            classe = '';
        }

        $("#linha"+linha).append("<td id=\""+dataAux.getTime()+"\" "+classe+">"+dataAux.getDate()+"</td>");

        dataAux.setDate(dataAux.getDate() + 1);
        count++;
    }
}

function atualizaDataAtividades(){
    $("#data").text(dataSelecionada.toLocaleDateString());

    let dia = dataSelecionada.getDate() < 10 ? ('0'+dataSelecionada.getDate()) : dataSelecionada.getDate();
    let mes = (dataSelecionada.getMonth()+1) < 10 ? ('0'+(dataSelecionada.getMonth()+1)) : (dataSelecionada.getMonth()+1);
    let ano = dataSelecionada.getFullYear();
    let data = ano+'-'+mes+'-'+dia;

    $.ajax({
        url: "/getAtividades",
        method: "POST",
        data:{
            data: data
        },
        success: function(data){
            $("#listaAtividades").text("");
            if(data.length > 0){
                $("#listaAtividades").html(data);
            }else{
                $("#listaAtividades").append('<h4 id="semAtividade" class="text-center mt-3" style="color: #777;">Não existem atividades cadastradas!</h4>');
            }
        },error: function(){
            alert("deu ruim");
        }
    });
}
function desativarLinks(){
    $('a').unbind().click(function(event){
        if(!$(this).hasClass('dropdown-toggle') && !$(this).hasClass('btnModal') ){
            event.preventDefault();
            if(!$(this).hasClass('btn') && !$(this).hasClass('dropdown-toggle')){
                $('a').removeClass('active disabled');
                $(this).addClass('active disabled');
            }
            controleDeRotas($(this).attr("href"));
        }
    });
}

function ativarClickCalendario(){
    $('td').click(function(params){
        if(!$(this).hasClass("outro-mes")){
            $('.dia-ativo').removeClass('dia-ativo');
            $(this).addClass('dia-ativo');
            dataSelecionada = new Date(parseInt(($(this).attr("id"))));
            atualizaDataAtividades();
        }
    });
}

function deleteAtividade(id){
    Swal.fire({
        title: "Realmente deseja excluir esta atividade?",
        text: "Esta atividade será removida permanentemente!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Excluir",
        cancelButtonText: "Cancelar"
    }).then((result) => {
        if (result.isConfirmed) {
            $.post("/deleteAtividade",{id: id}, function(data){
                toastAlert(data.sucesso ? "success" : "error" ,data.mensagem);
                $('#a'+id).remove();
            }).fail(function(){
                toastAlert("error","Falha na comunicação com o servidor!");
            });
        }
    });
}

function editaAtividade(id){
    $('#modalLabel').text('Editar Atividade');
    $("#idAtividade").val(id);
    $('#talhao').val($('#atividade' + id + ' .atividade-talhao').text());
    $('#cultura').val($('#atividade' + id + ' .atividade-cultura').text());
    $('#receita').val(parseFloat($('#atividade' + id + ' .atividade-receita').text().replace(/\./g, '')));
    $('#maoObra').val(parseFloat($('#atividade' + id + ' .atividade-custo').text().replace(/\./g, '')));
    $('#descricao').val($('#atividade' + id + ' .atividade-descricao').text());

    $('#modalAtividade').modal('show');
}

function limpaModal(){
    $('#modalAtividade').on('hidden.bs.modal', function () {
        $('#talhao').val('');
        $('#cultura').val('');
        $('#maoObra').val('');
        $('#receita').val('');
        $('#descricao').val('');
        $('#idAtividade').val('');
    });
}