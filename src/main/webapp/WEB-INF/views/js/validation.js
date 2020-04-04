function checkLength(){
    var textbox = document.getElementById("zipcode");
    if(textbox.value.length <= 9 && textbox.value.length >= 5){

    }
    else
    {
      alert("Zipcode should be of 5-9 characters long")

    }

}
