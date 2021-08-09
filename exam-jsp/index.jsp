<html>

<head>
  <title>Online Quiz</title>
</head>


<body bgcolor=wheat>
  <%@ include file="header.html" %>

    <form action="controller.jsp">
      <br>
      Seat number: <input type="text" name="seat">
      <div><br>
        Name: <input type="text" name="name" size="50"><br>
      </div>
      <br>
      <br>
      1.JAVA is a platform independent language<br />
      <input type="radio" name="answer1" value="True">True
      <input type="radio" name="answer1" value="False">False<br>
      2. ASP .NET is a client side programming<br />
      <input type="radio" name="answer2" value="True">True
      <input type="radio" name="answer2" value="False">False<br>
      3. MATHEMATICS is the backbone of engineering<br />
      <input type="radio" name="answer3" value="True">True
      <input type="radio" name="answer3" value="False">False<br>
      4. You are working in IBM machines<br />
      <input type="radio" name="answer4" value="True">True
      <input type="radio" name="answer4" value="False">False<br>
      5. JSP is used for buildling webapps<br />
      <input type="radio" name="answer5" value="True">True
      <input type="radio" name="answer5" value="False">False<br>
      <br><br><br>
      <input type="submit" value="submit"><br><br>
    </form>
</body>

</html>
