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

    // toggleContent 함수 내부에서 sendData 함수 호출
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

          // rows.addEventListener('click', function() {
          //   var boardNo = this.getAttribute('data-boardNo');
          //   sendData(boardNo);
          // });

          // sendData 함수 호출
          // var boardNo = this.dataset.boardNo;
          // console.log(boardNo);
          // sendData(boardNo);

          // var boardNo = $(this).parent().data('boardNo');
          // sendData(boardNo);
        });
      }
    }



    // sendData 함수를 toggleContent 함수 외부에서 정의
    function sendData(boardNo) {
      // var boardNo        = this.dataset.boardNo;
      console.log(boardNo);
      // AJAX로 boardNo를 서버에 전달하는 코드 작성
      $.ajax({
        url: "/boardRead/" + boardNo,
        type: "POST",
        success: function(data) {
          console.log(data);
          alert("성공입니다");
              $("#boardRegion").text(data[0].boardRegion);
              $("#boardInterest").text(data[0].boardInterest);
              $("#boardTitle").text(data[0].boardTitle);
              $("#boardName").text(data[0].boardName);
              $("#boardContent").text(data[0].boardContent);

          // $('#boardRead').html(response);
        },
        error: function(xhr, status, error) {
          console.error(xhr.responseText);
          alert("에러입니다");
        }
      });
    }


      /* var boardNo = $('#boardNo').val();

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
    }*/


