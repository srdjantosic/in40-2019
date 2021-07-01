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
            window.location.href = "Admin.html";
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

$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/fitnesscentar",                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let fitnesscentar of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + fitnesscentar.naziv + "</td>";       
                row += "<td>" + fitnesscentar.adresa + "</td>";
                row += "<td>" + fitnesscentar.broj_tel_centrale+ "</td>";
                row += "<td>" + fitnesscentar.email+ "</td>";
                btn = "<button class='btnObrisi' data-id=" + fitnesscentar.id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnUpdate' data-id=" + fitnesscentar.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                    

                $('#fitnessi').append(row);                      
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnObrisi', function () {
    let fitnessId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnesscentar/" + fitnessId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitnessId + '"]').parent().parent().remove();   
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});

$(document).on('click','.btnUpdate',function () {
    let fitnessId = this.dataset.id;
    let naziv= $("#nazivaField").val();
    let adresa = $("#adresaaField").val();
    let broj_tel_centrale = $("#braField").val();
    let email = $("#emailaField").val();
   

    let fitnesscentar={
        naziv,
        adresa,
        broj_tel_centrale,
        email
    }

$.ajax({
    type: "PUT",                                                
    url: "http://localhost:8080/api/fitnesscentar/" + fitnessId,                 
    dataType: "json",             
    contentType:"application/json",  
    data: JSON.stringify(fitnesscentar),                            
    success: function (response) {                              
        console.log("SUCCESS:\n", response);                    
             window.location.href = "Admin.html";  
        

         
    },
    error: function (response) {                                
        console.log("ERROR:\n", response);
    }
});
});
