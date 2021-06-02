
$(document).on("submit", "#RegistracijaForm", function (event) {     
    event.preventDefault();                                        

    let ime = $("#imeField").val();
    let prezime = $("#prezimeField").val();
    let korisnicko_ime = $("#kimeField").val();
    let email = $("#emailField").val();
    let lozinka = $("#passField").val();
    let datum_rodjenja = $("#datumField").val();
    let kontakt = $("#kontaktField").val();

    
    let newClan = {
        korisnicko_ime,
        lozinka,
        ime,
        prezime,
        kontakt,
        email,
        datum_rodjenja
         
       
    }
    
   
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/clan",                 
        dataType: "json",                                           
        contentType: "application/json",                           
        data: JSON.stringify(newClan),                          
        success: function (response) {                            
            console.log(response);                                  

            alert("Uspesno ste se registrovali");
            window.location.href = "index.html";                
        },
        error: function () {                                        
            alert("Greška prilikom registrovanja!");
        }
    });
});