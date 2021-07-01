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
                row += "<td>" + fitnesscentar.broj_tel_centrale + "</td>";
                row += "<td>" + fitnesscentar.email + "</td>";  
                btn = "<button class='btnDelete' data-id=" + fitnesscentar.id + ">Delete</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                    

                $('#centri').append(row);                      
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let fitnessId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnesscentar/" + fitnessId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitnessId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});