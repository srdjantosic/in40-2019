$(document).on("submit", "#TrenerForm", function (event) {     
    event.preventDefault();                                         

    
    let ime = $("#imeField").val();
    let prezime = $("#prezimeField").val();
    let korisnicko_ime = $("#kimeField").val();
    let email = $("#emailField").val();
    let lozinka = $("#passField").val();
    let datum_rodjenja = $("#datumField").val();
    let kontakt = $("#kontaktField").val();
    let aktivan=false;
    let newTrener = {
        korisnicko_ime,
        lozinka,
        ime,
        prezime,
        kontakt,
        email,
        datum_rodjenja,
        aktivan
    }
    
    
    $.ajax({
        type: "POST",                                              
        url: "http://localhost:8080/api/trener",                 
        dataType: "json",                                       
        contentType: "application/json",                           
        data: JSON.stringify(newTrener),                          
        success: function (response) {                              
            console.log(response);                                 

            alert("Uspesno ste se registrovali!");
            window.location.href = "index.html";                
        },
        error: function () {                                        
            alert("Greška prilikom registracije!");
        }
    });
});

