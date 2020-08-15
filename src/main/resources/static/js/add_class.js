$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/qlsvApp/list-departments",
        dataType: "json",
        success: function (response) {
            var dprtHtml = '';
            var len = response.length;
            for (var i = 0; i < len; i++) {
                dprtHtml += '<option value="' + response[i].id + '">' + response[i].name + '</option>'
            }
            $('#dprt').append(dprtHtml);
        },
        error: function () {
            alert("Co loi xay ra!");
        },
    });
});

$('#dprt').on('change', function () { //get all teacher to class text box
    var dprtId = $('#dprt').val();
    if (dprtId == 0) {
        alert("Vui long chon Khoa!!!")
    } else {
        $.ajax({
            type: "GET",
            url: "/qlsvApp/list-teacher/" + dprtId,
            dataType: "json",
            success: function (response) {
                if (response.length == 0) {
                    $('#tchr').empty();
                    $('#tchr').append('<option value="0">Khong co lop</option>');
                } else {
                    $('#tchr').empty();
                    $('#tchr').append('<option value="0">------------------</option>');
                    var clssHtml = '';
                    var len = response.length;
                    for (var i = 0; i < len; i++) {
                        clssHtml += '<option value="' + response[i].id + '">' + response[i].name + '</option>'
                    }
                    $('#tchr').append(clssHtml);
                }
            },
            error: function () {
                alert("Co loi xay ra!");
            },
        });
    }

});

$('#btn').on('click',function (e) {
    e.preventDefault();
    var data = JSON.stringify( $('form').formToJson());
    $.ajax({
        type: "POST",
        url: "/qlsvApp/add-new-class/",
        data: data,
        dataType: "json",
        contentType:'application/json',
        success: function (response) {
            alert('Them Lop hoc thanh cong !!!');
        },
        error: function(e){
            alert('Co loi xay ra');
        }
    });
});