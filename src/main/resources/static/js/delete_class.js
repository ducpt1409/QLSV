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

$('#dprt').on('change', function () {
    var dprtId = $('#dprt').val();
    if (dprtId == 0) {
        alert("Vui long chon Khoa!!!")
    } else {
        $.ajax({
            type: "GET",
            url: "/qlsvApp/classes/" + dprtId,
            dataType: "json",
            success: function (response) {
                if (response.length == 0) {
                    $('#clss').empty();
                    $('#clss').append('<option value="0">Khong co lop</option>');
                } else {
                    $('#clss').empty();
                    $('#clss').append('<option value="0">------------------</option>');
                    var clssHtml = '';
                    var len = response.length;
                    for (var i = 0; i < len; i++) {
                        clssHtml += '<option value="' + response[i].id + '">' + response[i].name + '</option>'
                    }
                    $('#clss').append(clssHtml);
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
    var classId = $('#clss').val();
    $.ajax({
        type: "GET",
        url: "/qlsvApp/delete-class/"+classId ,
        dataType: "json",
        contentType:'application/json',
        success: function (response) {
            alert('Da xoa lop hoc va sinh vien lop hoc !!!');
        },
        error: function(e){
            alert('Co loi xay ra');
        }
    });
});