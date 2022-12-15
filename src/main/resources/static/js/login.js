$(window).on({
   load: function() {
       // 회원가입
       $('#join').click(function() {
           console.log("join");
           var userNm = $('#userNm').val();
           var userId = $('#userId').val();
           var userPass = $('#userPass').val();
           var userTel = $('#userTel').val();
           var userEmail = $('#userEmail').val();

           if(userId !== '' && userPass !== '' && userNm !== '') {
               var sendData = {
                   userNm: userNm,
                   userId: userId,
                   userPass: userPass,
                   userTel: userTel,
                   userEmail: userEmail
               }

               $.ajax({
                   url: '/login/joinProcess',
                   async: true,
                   type: 'POST',
                   data: JSON.stringify(sendData),
                   dataType: 'json',
                   contentType: 'application/json',
                   success: function(result) {
                       if(result.resultCode == "200") {
                           alert("회원가입 성공");
                           location.href = "/main/main";
                       } else {
                           alert("회원가입 실패");
                       }
                   },
                   error: function(result) {
                       alert("회원가입 실패");
                       location.href = "/login/join";
                   },
                   complete: function(result) {
                       location.href = "/login/join";
                   }
               });
           } else {
               alert("회원가입에 필요한 정보가 없습니다.");
           }
       });

       $('#joinBtn').click(function() {
          location.href = "/login/join";
       });

       // 로그인
       $('#login').click(function() {
           console.log("login");
           var userId = $('#userId').val();
           var userPass = $('#userPass').val();
           var saveId = $('#saveId').val();
           console.log("userId : " + userId);
           console.log("userPass : " + userPass);

           if(userId !== '' && userPass !== '') {
               var sendData = {
                   userId: userId,
                   userPass: userPass,
                   saveId: saveId
               }

               $.ajax({
                   url: '/login/loginProcess',
                   async: true,
                   type: 'POST',
                   data: JSON.stringify(sendData),
                   dataType: 'json',
                   contentType: 'application/json',
                   success: function(result) {
                       if(result.resultCode == "200") {
                           alert("로그인 성공");
                           location.href = "/main/main";
                       } else {
                           alert("로그인 실패");
                       }
                   },
                   error: function(result) {
                       alert("로그인 실패");
                       location.href = "/login/login";
                   }
               });
           } else {
               alert("로그인에 필요한 정보가 없습니다.");
           }
       });
   }
});