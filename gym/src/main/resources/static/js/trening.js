$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/treninzi",                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
            $('#table').html(response);
            for (let trening of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trening.naziv + "</td>";       
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip_treninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.cena + "</td>";
            

                $('#treninzi').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});
  function k(){ 
   
  
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/treninzi/sortCena",                
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);    
            $('#Table').html(response);               
          
            for (let trening of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trening.naziv + "</td>";     
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip_treninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.cena + "</td>";
              

                $('#treninzi').append(row);                       
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
};    
  function m(){
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/treninzi/sortTermin",                
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                   
           // $('#treninzi').delete(row);  
            for (let trening of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trening.naziv + "</td>";     
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip_treninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.cena + "</td>";
               
                $('#treninzi').append(row);                       
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
};
