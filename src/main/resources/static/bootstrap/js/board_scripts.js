/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

    /* function changeClass(tr) {
      tr.classList.toggle('changeColor');
    } */



    /* $(document).ready(function(){

            // 특정 테이블의 row에 마우스 오버시 색상변경
            $( ".tb-list tbody tr" ).on( "mouseover", function() {
                $( this ).css( "background-color", "#f7f7f7" );
                //$( this).children("td").css( "cursor", "pointer" );
            });
            $( ".tb-list tbody tr" ).on( "mouseleave", function() {
                $( this ).css( "background-color", "white" );
            });

        }); */


    function toggleContent() {
      var rows = document.getElementsByClassName("view");
      var i;

      for (i = 0; i < rows.length; i++) {
        rows[i].addEventListener("click", function() {
          var content = this.nextElementSibling;
          if (content.style.display === "table-row") {
            content.style.display = "none";
            this.classList.remove('changeColor'); // 색상 클래스 제거
          } else {
            content.style.display = "table-row";
            this.classList.add('changeColor'); // 색상 클래스 추가
          }

          $.ajax({
            url:'./boardRead',
            type:'GET', //POST 방식으로 전달
            data:{boardNo:boardNo},
            success:function(result){
                    alert("성공입니다");
            },
                  error:function(){
                    alert("에러입니다");
                }
          });
        });
      }
    }


