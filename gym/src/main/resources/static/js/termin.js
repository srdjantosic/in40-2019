$(document).ready(function () {  
    let korisnicko_ime = localStorage.getItem('korisnik');
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/sala/" +korisnicko_ime,                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
            var sale = [];
            for (let sala of response) { 
                console.log(sala);  
                let s = {};                     
                /*let row = "<tr>";                                   
                row += "<td>" + termin.datum + "</td>";     
                row += "<td>" + termin.trening.naziv + "</td>";
                row += "<td>" + termin.trening.cena + "</td>";
                row += "<td>" + termin.sala.oznaka + "</td>";
              
                btn = "<button class='btnBris' data-id=" + termin.id+ ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnUpdat' data-id=" + termin.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";
                
                row += "</tr>";                                    

                $('#termini').append(row); */                     
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.btnBris', function () {
    let terminId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/termin/" + terminId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + terminId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja termina!");
        }
    });
});

$(document).on('click','.btnUpdat',function () {
    let terminId = this.dataset.id;
    let datum=$("#datumiiiField").val();
    let naziv=$("#select").val();
   

    let termin={
       datum
    }

$.ajax({
    type: "PUT",                                                
    url: "http://localhost:8080/api/termin/" + terminId,                 
    dataType: "json",             
    contentType:"application/json",  
    data: JSON.stringify(termin),                            
    success: function (response) {                              
        console.log("SUCCESS:\n", response);                    
             window.location.href = "Trener.html";  
        

         
    },
    error: function (response) {                                
        console.log("ERROR:\n", response);
    }
});
});

$(document).on("submit", "#terminform", function (event) {     
    event.preventDefault();                                        

    let datum= $("#datumiiField").val();
    let naziv = $("#select1").val();
    let cena=$("#cenaField").val();
    let oznaka=$("#select2").val();

    
    
    let newTermin = {
       datum,
       naziv,
       cena,
       oznaka
       
        
    }
    
   
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/termin",                 
        dataType: "json",                                           
        contentType: "application/json",                           
        data: JSON.stringify(newTermin),                          
        success: function (response) {                            
            console.log(response);                                  

            alert("Uspesno dodat termin");
            window.location.href = "Trener.html";
        },
        error: function () {                                        
            alert("Greška prilikom dodavanja!");
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
                var text = fitnesscentar.naziv;
                var value = fitnesscentar.naziv;                      
                var option = new Option(text, value); $('#select').append($(option));                    
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});
$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/trening",                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let trening of response) {  
                var text = trening.naziv;
                var value = trening.naziv;                      
                var option = new Option(text, value); $('#select1').append($(option));       
                  
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});
