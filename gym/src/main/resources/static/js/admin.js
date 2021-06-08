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

$(document).ready(function () {
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/trener/aktivan",                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
          
            for (let trener of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trener.ime + "</td>";       
                row += "<td>" + trener.prezime + "</td>";
                let btn = "<button class='btnPrihvati' data-id=" + trener.korisnicko_ime + ">Prihvati</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
            

                $('#zahtevi').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click','.btnPrihvati',function () {
    let trenerKime = this.dataset.id;
  
    let trener={
        trenerKime,
    }

    
    
    $.ajax({
        type: "PUT",                                                
        url: "http://localhost:8080/api/trener/updateTrener/" + trenerKime,                 
        dataType: "json",             
        contentType:"application/json",  
        data: JSON.stringify(trener),                            
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
            $('[data-id="' + trenerKime + '"]').parent().parent().remove();
            

             
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});
