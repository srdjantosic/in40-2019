$(document).ready(function () {    
   let clanId=localStorage.getItem('korisnik');
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/clan/" +clanId,                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
         
            for (let trening of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trening.naziv + "</td>";       
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip_treninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.termin.datum + "</td>";
                row += "<td>" + trening.fitness.naziv + "</td>";
                btn = "<button class='btnOdradi' data-id=" + trening.id + ">Odradi trening</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnOtkazi' data-id=" + trening.id + ">Otkazi trening</button>";
                row += "<td>" + btn + "</td>";
            

                $('#prijavljeni').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnOdradi', function () {
    let treningId = this.dataset.id;
    let clanId = localStorage.getItem('korisnik');
    console.log(clanId);
    

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin/odraditrening/" + treningId +"/" + clanId,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS");
            alert("Uspeh prilikom prijavljivanja!");
        },
        error: function (response) {
            if(response.status == "200"){
                alert("Trening je odradjen!");
                $('[data-id="' + treningId + '"]').parent().parent().remove();
            }else{
                alert("Greska prilikom odradjivanja treninga!");
            }
            
        }
    });
});

$(document).ready(function () {    
  let clanId=localStorage.getItem('korisnik');
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/clan/odradjeni/" +clanId,                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    
         
            for (let trening of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trening.naziv + "</td>";       
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip_treninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.termin.datum + "</td>";
                row += "<td>" + trening.fitness.naziv + "</td>";
                
            

                $('#odradjeni').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});

$(document).ready(function () {    
  let clanId=localStorage.getItem('korisnik');
  
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/clan/prikazi/" + clanId,
    dataType: "json",
    success: function (response) {                        
        console.log("SUCCESS:\n", response);  
          
        let row = "<tr>";  
        row += "<td>" + response.ime + "</td>";       
        row += "<td>" + response.prezime + "</td>";
        row += "<td>" + response.korisnicko_ime + "</td>";
        row += "<td>" + response.email + "</td>";
        row += "<td>" + response.lozinka + "</td>";
        row += "<td>" + response.datum_rodjenja + "</td>";
        row += "<td>" + response.kontakt + "</td>";
        

        $('#pregledaj').append(row);
       
    },
    error: function (response) {                            
        console.log("ERROR:\n", response);
    }
});
});
