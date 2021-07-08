$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/sala",                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let sala of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + sala.kapacitet + "</td>";     
                row += "<td>" + sala.oznaka + "</td>";
                row += "<td>" + sala.fitnessCentar.naziv+ "</td>";
                btn = "<button class='btnDelete' data-id=" + sala.id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnAzuriraj' data-id=" + sala.id + ">Azuriraj</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                    

                $('#sale').append(row);                      
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let salaId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/sala/" + salaId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + salaId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});

$(document).on("submit", "#dodaj", function (event) {     
    event.preventDefault();                                        

    let kapacitet= $("#kapField").val();
    let oznaka = $("#oznakaField").val();
    let naziv=$("#select").val();
    
   
    
    
    let newSala= {
       kapacitet,
       oznaka,
        
    }
    
   
    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/api/sala/" +naziv,                 
        dataType: "json",                                           
        contentType: "application/json",                           
        data: JSON.stringify(newSala),                          
        success: function (response) {                            
            console.log(response);                                  

            alert("Uspesno dodata sala");
            window.location.href = "PregledSala.html";              

                            
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

$(document).on('click','.btnAzuriraj',function () {
    let salaId = this.dataset.id;
  let kapacitet=$("#kapaField").val();
  let oznaka=$("#oznakaaField").val();
  
    let sala={
        kapacitet,
        oznaka
        
        
    }

$.ajax({
    type: "PUT",                                                
    url: "http://localhost:8080/api/sala/" + salaId  ,                 
    dataType: "json",             
    contentType:"application/json",  
    data: JSON.stringify(sala),                            
    success: function (response) {                              
        console.log("SUCCESS:\n", response);                    
             window.location.href = "PregledSala.html";  
        

         
    },
    error: function (response) {                                
        console.log("ERROR:\n", response);
    }
});
});
