$(document).on("submit", "#Prijava", function (event) {     
    event.preventDefault();                                           
    let korisnicko_ime = $("#kimeField").val();
    let lozinka = $("#passField").val();
    let role;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/login/" + korisnicko_ime +"/"+lozinka,
        dataType: "json",
        success: function (response) {                          
            console.log("SUCCESS:\n", response);               
            localStorage.setItem('korisnik', response);
            if(response.role=="ADMIN"){
                window.location.href = "Admin.html";
            }
            else {
            window.location.href = "HomePage.html";              
            } 

           
                    

                                         
        },
         error: function() {    
            alert("Pogresno korisnicko ime ili lozinka!");                        
            window.location.href = "index.html";              

        }
    });

});