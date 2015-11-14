<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>

    <head>
        <title>Ezee Pay Back</title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href="http://fonts.googleapis.com/css?family=Cantarell:regular,italic,bold,bolditalic" rel="stylesheet" />
        <link href="http://fonts.googleapis.com/css?family=Droid+Serif:regular,italic,bold,bolditalic" rel="stylesheet" />
        <!--<link rel="stylesheet" href="grey.css" />-->
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
    </head>

    <body>
        <div id="main">
            <header>
                <div id="logo">
                    <div id="logo_text">
                        <!-- class="logo_colour", allows you to change the colour of the text -->
                        <h1><a href="index.html">Ezee Pay Back<span class="logo_colour"></span></a></h1>
                        <!--<h2>Simple. Contemporary. Website Template.</h2>-->
                    </div>
                </div>
                <nav>
                    <div id="menu_container">
                        <ul class="sf-menu" id="nav">
                            <li><a href="index.html">User Management</a>

                                <ul>
                                    <li><a href="#">New User</a></li>
                                    <li><a href="javaScript:void(0)" onclick="getEditUserLandingPage()">Edit User</a></li>
                                    <li><a href="#">User-Role mgmt</a></li>
                                    <li><a href="#">Password reset</a></li>
                                </ul>  

                            </li>
                            <li><a href="examples.html">Customer Mgmt</a>
                                <ul>
                                    <li><a href="#">KYC Approvals</a></li>
                                    <li><a href="#">Edit customer</a></li>
                                    <li><a href="#">Password reset</a></li>
                                    <li><a href="#">mPin reset</a></li>
                                    <li><a href="#">Wallet upload approvals</a></li>
                                    <li><a href="#">Bulk customer upload</a></li>
                                </ul>  

                            </li>
                            <li><a href="page.html">Merchant Mgmt</a>

                                <ul>
                                    <li><a href="#">New merchant</a></li>
                                    <li><a href="#">Edit merchant</a></li>
                                    <li><a href="#">Password reset</a></li>
                                </ul> 

                            </li>
                            <li><a href="another_page.html">Agent Mgmt</a>

                                <ul>
                                    <li><a href="#">New Agent</a></li>
                                    <li><a href="#">Edit Agent</a></li>
                                    <li><a href="#">Password reset</a></li>
                                    <li><a href="#">mPin reset</a></li>
                                </ul>  

                            </li>
                            <li><a href="index.html">Transaction Mgmt</a>

                                <ul>
                                    <li><a href="#">View transactions</a></li>
                                    <li><a href="#">Bulk wallet upload</a></li>
                                    <li><a href="#">Scheduled Transactions </a></li>
                                    <li><a href="#">Standing Instructions </a></li>
                                </ul> 

                            </li>
                            <li><a href="examples.html">Reports</a>

                                <ul>
                                    <li><a href="#">Daily reports</a></li>
                                    <li><a href="#">Weekly reports</a></li>
                                    <li><a href="#">Monthly reports </a></li>
                                    <li><a href="#">Regulatory/compliance</a></li>
                                </ul> 

                            </li>
                            <li><a href="page.html">Support</a>

                                <ul>
                                    <li><a href="#">View tickets</a></li>
                                    <li><a href="#">Dispute resolution</a></li>                                   
                                </ul>

                            </li>
                            <li><a href="another_page.html">Logout</a></li>

                        </ul>
                    </div>
                </nav>
            </header>