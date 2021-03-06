<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>SMOOSS</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/home_user.css">
</head>

<body>
	<jsp:useBean id="events" scope="request" beanName="events"
		type="java.util.ArrayList<com.aplose.smooss.model.Event>"></jsp:useBean>
	<div class="container-fluid">
		<div class="row" id="disconnect_button">
			<!-- Include for the html of the disconnect_button -->
			<!-- <?php include "inc/disconnect_button.php"; ?> -->
			<%@ include file="disconnect_button.jsp"%>
		</div>

		<div class="row justify-content-center" id="title">
			<h1>&#149; SMOOSS &#149;</h1>
			<h6>
				Bienvenu sur Smooss
				<%=(String) session.getAttribute("firstname")%>
			</h6>
		</div>

		<div class="row justify-content-center" id="middle_blocks">
			<div class="clip-block">
				<a data-toggle="modal" data-target="#modalEventInfo">
					<div class="clip-each clip-solid">
						<div class="clip-caption">
							<i class="fal fa-4x fa-calendar-alt"></i>
						</div>
						<div class="social-share-block">
							<span class="social-each"></span> <span> <i
								class="fas fa-plus"></i>
							</span>
						</div>
					</div>
				</a>
			</div>
			<div class="clip-block">
				<a href="managementProfil.view" class="clip-each clip-gradient">
					<div class="clip-caption">
						<i class="fas fa-3x fa-user"></i>
					</div>
				</a>
			</div>
			<div class="clip-block">
				<a href="mesInvitations.php">
					<div class="clip-each clip-solid">
						<div class="clip-caption">
							<i class="fas fa-5x fa-envelope" style="color: #fff;"></i>
						</div>
						<div class="social-share-block">
							<span class="social-each"> <strong>4</strong>
							</span> <span> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>
				</a>
			</div>
		</div>
		<div class="row justify-content-center" id="div_event_list">
			<table>
				<caption class="text-center">Ma liste d'évènements</caption>
				<tbody id="body_event_list">
					<c:forEach var="event" items="${events}">
							<tr class="block_event_list">
								<td class="title_td" id="title"><a href="EventController?idEvent=${event.id}">${event.name}</a></td>
								<td class="description_td" id="description">${event.description}</td>
								<td class="date_td" id="date">${event.start}</td>
								<td id="map"><a target="_blank"
									href="https://www.google.com/maps/place/${event.localisation}">Voir
										sur Maps</a></td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<svg class="clip-svg">
                <defs>
                    <clipPath id="hexagon-clip"
				clipPathUnits="objectBoundingBox">
                        <polygon
				points="0.25 0.05, 0.75 0.05, 1 0.5, 0.75 0.95, 0.25 0.95, 0 0.5" />
                    </clipPath>
                </defs>
            </svg>

		<svg class="clip-svg">
                <defs>
                    <clipPath id="triangle-clip"
				clipPathUnits="objectBoundingBox">
                        <polygon points="1 0.03, 0.17 1, 1 1" />
                    </clipPath>
                </defs>
            </svg>
	</div>

	<div class="modal fade" id="modalInformationEvent" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header" id="div_modal_title">
					<h5 class="modal-title" id="modal_title_event"></h5>
				</div>
				<div class="modal-body" id="block_body_event">
					<div id="modal_map_event"></div>
					<div class="block_description_date_event">
						<div id="modal_description_event"></div>
						<div id="modal_date_event"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

          <div class="modal fade" id="modalEventInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" style="color: black;">Nouvel évènement</h5>
                    </div>
                    <form method="POST" action="EventController" enctype="multipart/form-data">
	                    <div class="modal-body">
	                    	<div class="form-group">
	                    		<div class="input-group">
	                    			<label for="pictureEvent" style="color: black;">Choisir une image :</label>
	                    			<input type="file" name="pictureEvent" accept="image/*">
	                    		</div>
	                    	</div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="titleEvent" placeholder="Nom de l'évènement" class="input_modal">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <textarea style="resize: none;" name="descriptionEvent" class="input-event" rows="4" cols="50" placeholder="Description de l'évènement"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" name="locationEvent" id="adresse" placeholder="Adresse de l'évènement">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="date" name="startDateEvent" id="startDateEvent">
                                    <input type="time" name="startTimeEvent" id="startTimeEvent">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="date" name="endDateEvent" id="endDateEvent">
                                    <input type="time" name="endTimeEvent" id="endTimeEvent">
                                </div>
                            </div>
                            <h5 style="color: black">Selectionner vos modules pour votre
                            évènement:</h5>
                        <div style="color: black">
                            <div>
                                <input type="checkbox" id="PlaylistModule" name="PlaylistModule" value="checked"> <label
                                    for="">PlayList</label>
                            </div>
                            <div>
                                <input type="checkbox" id="TriCountModule" name="TriCountModule" value="checked"> <label
                                    for="">Gestion des dépenses</label>
                            </div>
                            <div>
                                <input type="checkbox" id="PicturesModule" name="PicturesModule" value="checked"> <label
                                    for="">Photos</label>
                            </div>
                            <div>
                                <input type="checkbox" id="ChatModule" name="ChatModule" value="checked"> <label
                                    for="">Chat</label>
                            </div>
                            <div>
                                <input type="checkbox" id="MiniGameModule" name="MiniGameModule" value="checked"> <label
                                    for="">Mini-jeux</label>
                            </div>
                            <div>
                                <input type="checkbox" id="CarpoolingModule" name="CarpoolingModule" value="checked"> <label
                                    for="">Covoiturage</label>
                            </div>
                            <div>
                                <input type="checkbox" id="BringModule" name="BringModule" value="checked"> <label
                                    for="">Liste de courses</label>
                            </div>
                        </div>
	                    </div>
	                    <div class="modal-footer justify-content-center">
                            <button type="submit" class="btn btn-success button_submit_modal" id="button_submit_connexion_modal"> Créer un évènement </button>
	                    </div>
	            	</form>
                </div>
            </div>
        </div>
        

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<script src="js/fontawesome-all.min.js"></script>
	<!--  script src="js/home_user.js"></script-->
</body>
</html>