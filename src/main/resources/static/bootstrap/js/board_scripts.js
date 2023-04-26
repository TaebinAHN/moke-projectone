/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

    var rows = document.getElementsByClassName("view");// view 라는 classname의 모든 element들 가져오기.
        var i;

        for (i = 0; i < rows.length; i++) { //elements를 for문으로 돌려서 각행에 클릭 리스너 등록.
            rows[i].addEventListener("click", function() {

                var content = this.nextElementSibling;
                //display:table-row는 요소를 표 내의 행처럼 보이게한다.
                if (content.style.display === "table-row") {
                content.style.display = "none";
                } else {
                content.style.display = "table-row";
                }

            });//click event
        }//for문

        /* function boardSave() {

            console.log("1차")

            // var boardNo          = $("#boardNo").val();
            var boardInterest    = $("#boardInterest").val();
            var boardTitle       = $("#boardTitle").val();
            var boardContent     = $("#boardContent").val();
            var boardName        = $("#boardName").val();
            // var boardDate        = $("#boardDate").val();
            // var boardChk         = $("#boardChk").val();
            // var boardLike        = $("#boardLike").val();
            var boardRegion      = $("#boardRegion").val();

            if(! $("#boardInterest").val()) {
                  alert("관심사를 선택해주세요");
                  $("#boardInterest").focus();
                  // msg_err = "E";
                  return false;
            }
            if(! $("#boardTitle").val()) {
                 alert("관심사를 선택해주세요");
                 $("#boardTitle").focus();
                 // msg_err = "E";
                 return false;
            }

            if(! $("#boardContent").val()) {
                 alert("관심사를 선택해주세요");
                 $("#boardContent").focus();
                 // msg_err = "E";
                 return false;
            }

            if(! $("#boardName").val()) {
                 alert("관심사를 선택해주세요");
                 $("#boardName").focus();
                 // msg_err = "E";
                 return false;
            }

            if(! $("#boardRegion").val()) {
                 alert("관심사를 선택해주세요");
                 $("#boardRegion").focus();
                 // msg_err = "E";
                 return false;
            }

            var allData = {
            					"board_interest"        :  boardInterest   ,
            					"board_title"           :  boardTitle      ,
            					"board_content"         :  boardContent    ,
            					"board_name"            :  boardName       ,
            					"board_region"          :  boardRegion
            			   };
            console.log("2차")

            $.ajax({
                    //console.log("3차")
                    url:"./write",
                    data:allData,
                    dataType:"json",
                    success:function(result){
                        console.log("4차")
                        alert("등록되었습니다.");

                    }, error:function(jqXHR, textStatus, errorThrown){
                             console.log("에러 발생: ", textStatus, errorThrown);
                             alert("에러가 발생했습니다.");}
              }); // ajax end

        } */
