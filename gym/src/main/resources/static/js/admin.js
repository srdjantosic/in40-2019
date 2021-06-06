$(document).on("submit", "#Fitnesscentarform", function (event) {     
    event.preventDefault();                                        

    let naziv= $("#nazivField").val();
    let adresa = $("#adresaField").val();
    let broj_tel_centrale = $("#brField").val();
    let email = $("#emailField").val();
   
    
    
    let newFitnessCentar = {
        naziv,
        adresa,
        broj_tel_centrale,
        email,
        
    }
    
   
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/fitnesscentar",                 
        dataType: "json",                                           
        contentType: "application/json",                           
        data: JSON.stringify(newFitnessCentar),                          
        success: function (response) {                            
            console.log(response);                                  

            alert("Uspesno dodat fitness centar");
                            
        },
        error: function () {                                        
            alert("Greška prilikom dodavanja!");
        }
    });
});