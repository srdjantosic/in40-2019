$(document).on("submit", "#dodajte", function (event) {     
    event.preventDefault();                                         

    
    let ime = $("#imeiField").val();
    let prezime = $("#prezimeiField").val();
    let korisnicko_ime = $("#kimeiField").val();
    let email = $("#emailiField").val();
    let lozinka = $("#passiField").val();
    let datum_rodjenja = $("#datumiField").val();
    let kontakt = $("#kontaktiField").val();
    
    let newTrener = {
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
        url: "http://localhost:8080/api/trener/aktivnost",                 
        dataType: "json",                                       
        contentType: "application/json",                           
        data: JSON.stringify(newTrener),                          
        success: function (response) {                              
            console.log(response);                                 

            alert("Uspesno ste se registrovali!");
            window.location.href = "Admin.html";                
        },
        error: function () {                                        
            alert("Greška prilikom registracije!");
        }
    });
});