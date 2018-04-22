<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="css/event.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1" crossorigin="anonymous">
    </head>
    <body>
        
        <form method="POST" action="EventController">
        	<div class="container-fluid img-title-description-event-block">
		        <img src=".\img\event-category-cover-pictures-soiree.jpg" id="imgParty" alt="Image de votre évènement">
		        <div class="title-description-event">
					<c:choose>
					</c:choose>
		        	<h2> <input type="text" class="input-event" name="titleEvent" id="titleEvent" placeholder="Nom de l'évènement"> </h2>
		        	<textarea style="resize: none;" name="descriptionEvent" class="input-event" rows="4" cols="50" placeholder="Description de l'évènement"></textarea>
		   		</div>
			</div>
	        <div class="container">
	            <div class="row justify-content-center mt-4">
	                <!-- <div class="col-sm-3">
	                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2889.1541762818792!2d3.9077731149273682!3d43.60333136367297!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12b6a57c3fa4f34d%3A0xec9311353c764d24!2sMill%C3%A9naire!5e0!3m2!1sfr!2sfr!4v1522785402462"
	                        width="200" height="200" frameborder="0" style="border:0; border-radius:8px;" allowfullscreen></iframe>
	                </div> -->
	                <div class="event-info">
	                	<div class="">
	                		Adresse : 
	                		<input type="text" name="locationEvent" id="adresse">
	                	</div>
	                  	<div class="start-date-time-event">
		                  	Début :
		                  	<input type="date" name="startDateEvent" id="startDateEvent">
		                  	<input type="time" name="startTimeEvent" id="startTimeEvent">
	                  	</div>
	                  	<div class="end-date-time-event">
		                  	Fin :
		                  	<input type="date" name="endDateEvent" id="endDateEvent">
		                  	<input type="time" name="endTimeEvent" id="endTimeEvent">
	                    </div>
	                    <hr>
	                    <input type="submit" name="submitButton" id="submitButton" value="Créer mon Smooss">
	                </div>
	            </div>
        </form>
       
            <div class="row justify-content-around mt-5 color_text" id="module_block">
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-music fa-5x center_icon_test"></i>                    
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-dollar-sign fa-5x center_icon_test"></i>
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-camera-retro fa-5x center_icon_test"></i>
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-comments fa-5x center_icon_test"></i>
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-gamepad fa-5x center_icon_test"></i>
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                        <i class="fas fa-car fa-5x center_icon_test"></i>
                    </a>
                </div>
                <div class="hexagon_module">
                    <a href="#">
                            <i class="fas fa-people-carry fa-5x center_icon_test"></i>
                    </a>
                </div>
            </div>
            <div class="row justify-content-center mt-5">
                <a href="#" id="button_redirect_home"> Retour à l'accueil </a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/event.js"></script>
        
    </body>
</html>

