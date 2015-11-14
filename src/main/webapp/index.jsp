
<%-- <%@taglib uri="/struts-tags" prefix="s"%> --%>

<%-- <jsp:include page="header.jsp" /> --%>
<div id="site_content">

	<s:form action="adduser" method="post" theme="simple">
		<fieldset>
			<legend>Add User</legend>
			<p>
				<label for="name">First Name:</label>
				<s:textfiled name="userForm.firstName" id="name" />
			</p>
			<p>
				<label for="userForm.lastName">Last Name:</label>
				<s:textfiled name="userForm.lastName" id="name" />
			</p>
			<p>
				<label for="userForm.gender">Gender:</label> <select
					name="userForm.gender" id="sel">
					<option>Male</option>
					<option>Female</option>
				</select>

			</p>
			<p>
				<label for="email">Date Of Birth:</label>
				<s:textfiled name="userForm.userDateOfBirth" id="email" />
			</p>
			<p>
				<label for="email">Address1:</label>
				<s:textfiled name="userForm.addressOne" id="email" />
			</p>
			<p>
				<label for="email">Address2:</label>
				<s:textfiled name="userForm.addressTwo" id="email" />
			</p>
			<p>
				<label for="email">Address3:</label>
				<s:textfiled name="userForm.addressThree" id="email" />
			</p>
			<p>
				<label for="email">City:</label>
				<s:textfiled name="userForm.city" id="email" />
			</p>
			<p>
				<label for="email">State:</label>
				<s:textfiled name="userForm.state" id="email" />
			</p>
			<p>
				<label for="email">Country:</label>
				<s:textfiled name="userForm.country" id="email" />
			</p>
			<p>
				<label for="email">Land Line Number:</label>
				<s:textfiled name="userForm.landLineNumber" id="email" />
			</p>
			<p>
				<label for="email">Mobile Number:</label>
				<s:textfiled name="userForm.mobileNumber" id="email" />
			</p>
			<p>
				<label for="email">Email Id:</label>
				<s:textfiled name="userForm.emailId" id="email" />
			</p>
			<!-- <p>
                            <label for="username">Desired Username:</label>
                            <input type="text" name="username" id="username" />
                        </p>
                        <p>
                            <label for="password">Password:</label>
                            <input type="password" name="password" id="password" />
                        </p>
                        <p>
                            <label for="passwordc">Password Confirmation:</label>
                            <input type="password" name="passwordc" id="passwordc" />
                        </p> -->
			<p>
				<label for="sel">Status:</label> <select name="userForm.status"
					id="sel">
					<option value="true">Active</option>
					<option value="false">In-active</option>
				</select>
			</p>
			<p>
				<label for="sel">Role:</label> <select name="userForm.role" id="sel">
					<option>Administrator</option>
					<option>Power</option>
					<option>Normal</option>
				</select>
			</p>
			<!-- <p>
                            <label for="tos">Agree to the Terms of Service</label>
                            <input type="checkbox" name="tos" value="agree" id="tos" />
                        </p> -->
			<p class="nolabel">
				<input type="submit" value="Sign Up!" />
			</p>
		</fieldset>
		</s:form>
		<!--                <div id="sidebar_container">
                                    <div class="sidebar">
                                        
                                    </div>
                                    <div class="sidebar">
                                        
                                    </div>
                                    <div class="sidebar">
                                        
                                    </div>
                                </div>-->
		<div class="content"></div>
</div>
<div id="scroll">
	<a title="Scroll to the top" class="top" href="#"><img
		src="images/top.png" alt="top" /></a>
</div>
<footer> </footer>
</div>
<!-- javascript at the bottom for fast page loading -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
<script type="text/javascript" src="js/jquery.sooperfish.js"></script>
<script type="text/javascript" src="js/jquery.sooperfish.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('ul.sf-menu').sooperfish();
		$('.top').click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 'fast');
			return false;
		});
	});
</script>
<script src="js/modernizr-1.5.min.js"></script>
</body>
</html>
