$(document).ready(function () { // get all department to department textbox
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

$('#dprt').on('change', function () { //get all department to class text box
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

$('#btnSubmit').on("click", function () { //find all
    var classId = $('#clss').val();
    if (classId == 0) {
        alert("Vui long chon lop hoc chinh xac");
    } else {
        $.ajax({
            type: "GET",
            url: "/qlsvApp/students/" + classId,
            dataType: "json",
            success: function (response) {
                $('#studentTable').empty();
                $('#studentTable').append('<tr>\n' +
                    '                        <td>Ma sinh vien</td>\n' +
                    '                        <td>Ho va Ten</td>\n' +
                    '                        <td>Que quan</td>\n' +
                    '                        <td>Ngay sinh</td>\n' +
                    '                        <td>Diem trung binh</td>\n' +
                    '                        <td>Xoa sinh vien</td>\n' +
                    '                    </tr>');
                if (response.length == 0) {
                    alert("Lop hoc khong co sinh vien !!!");
                } else {
                    for (var i = 0; i < response.length; i++) {
                        var html = "";
                        html += '<tr> <td><a href="/qlsvApp/student-detail/' + response[i].id + '">' + response[i].id + '</a></td> <td>' + response[i].name + "</td> <td>" +
                            response[i].country + "</td> <td>" + response[i].doB + "</td> <td>" + response[i].average + "</td> " +
                            '<td> <a href="/qlsvApp/delete-student/' + response[i].id + '">Xoa</a> </td> </tr>'
                        $('#studentTable').append(html)
                    }
                }
            },
            error: function () {
                alert("Co loi xay ra");
            }
        });
    }
});