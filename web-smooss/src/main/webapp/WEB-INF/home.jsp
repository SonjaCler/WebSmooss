<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="container-fluid">
            <div class="row" id="disconnect_button">
                <!-- Include for the html of the disconnect_button -->
                <!-- <?php include "inc/disconnect_button.php"; ?> -->
                <%@ include file="disconnect_button.jsp" %>
            </div>

            <div class="row justify-content-center" id="title">
                <h1>&#149; SMOOSS &#149; </h1>
                <h6>Bienvenu sur Smooss <%= (String)session.getAttribute("firstname") %> </h6>
            </div>
            
            <div class="row justify-content-center" id="middle_blocks">
                <div class="clip-block">
                	<a href="event.view">
	                    <div class="clip-each clip-solid">
	                        <div class="clip-caption">
	                                <i class="fal fa-4x fa-calendar-alt"></i>
	                        </div>
	                        <div class="social-share-block">
	                            <span class="social-each"></span>
	                            <span>
	                                <i class="fas fa-plus"></i>
	                            </span>
	                        </div>
	                    </div>
	            	</a>
                </div>
                <div class="clip-block">
                    <a href="gestionProfil.php" class="clip-each clip-gradient">
                        <div class="clip-caption"> <i class="fas fa-3x fa-user"></i> </div>
                    </a>
                </div>
                <div class="clip-block">
                    <a href="mesInvitations.php">
                        <div class="clip-each clip-solid">
                            <div class="clip-caption"> <i class="fas fa-5x fa-envelope" style="color:#fff;"></i> </div>
                            <div class="social-share-block">
                                <span class="social-each">
                                    <strong>4</strong>
                                </span>
                                <span>
                                    <i class="fas fa-envelope"></i>
                                </span>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="row justify-content-center" id="div_event_list">
                <table>
                    <caption class="text-center">Ma liste d'évènements</caption>
                    <tbody id="body_event_list"></tbody>
                </table>
            </div>
            <svg class="clip-svg">
                <defs>
                    <clipPath id="hexagon-clip" clipPathUnits="objectBoundingBox">
                        <polygon points="0.25 0.05, 0.75 0.05, 1 0.5, 0.75 0.95, 0.25 0.95, 0 0.5" />
                    </clipPath>
                </defs>
            </svg>

            <svg class="clip-svg">
                <defs>
                    <clipPath id="triangle-clip" clipPathUnits="objectBoundingBox">
                        <polygon points="1 0.03, 0.17 1, 1 1" />
                    </clipPath>
                </defs>
            </svg>
        </div>

        <div class="modal fade" id="modalInformationEvent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
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
        

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <script src="js/fontawesome-all.min.js"></script>
        <script src="js/home_user.js"></script>
    </body>
</html>