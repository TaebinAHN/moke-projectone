/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
        function checkId(){
            var userId = $('#inputId').val();
            $.ajax({
                url:'./idCheck', //Controller에서 요청 받을 주소
                type:'GET', //POST 방식으로 전달
                data:{userId:userId},
                success:function(result){ //컨트롤러에서 넘어온 cnt값을 받는다
                    if(result == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                        $('.id_ok').css("display","inline-block");
                        $('.id_already').css("display", "none");
                    } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display","inline-block");
                        $('.id_ok').css("display", "none");
                        alert("아이디를 다시 입력해주세요");
                        $('#inputId').val('');
                    }
                },
                error:function(){
                    alert("에러입니다");
                }
            });
        }