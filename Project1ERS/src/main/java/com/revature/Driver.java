package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.UsersController;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
			Javalin app = Javalin.create( (config) -> {
				config.enableCorsForAllOrigins();
				config.defaultContentType = "application/json";

			}).start();
			
			app.before(ctx -> {
			    ctx.header("Access-Control-Allow-Headers", "Authorization");
			    ctx.header("Access-Control-Expose-Headers", "Authorization");
			});
		
		app.routes(() -> {
			
			path("employees", () -> {
				path("all", () -> {
					get(ManagerController::viewAllEmployees);
				});
			});
			
			path("auth", () -> {
				post(AuthController::loginSystem); //Employees and Managers can login
			});
			path("account", () -> {
				path("{id}", () -> {
					get(UsersController::viewMyInfo); //view info
					put(UsersController::updateMyInfo); //update info
				});
			});
			
			path("reimbursement", () -> {
				get(ManagerController::viewAll);
				
				path("{id}", () -> {
					post(EmployeeController::submitMyRequest); // Employees can submit
					put(ManagerController::updateReStatus); //Managers can accept or deny requests
				});
				
			});
			path("pending", () -> {
				path("manager", () -> {
					get(ManagerController::viewAllPending); //Managers can get all pending requests
				});
				path("{id}", () -> {
					get(EmployeeController::viewMyPending); //Employees can view their pending
				});
			});
			
			path("resolved", () -> {
				path("manager", () -> {
					get(ManagerController::viewAllResolved); // Managers can view all resolved
				});
				path("{id}", () -> {
					get(EmployeeController::viewMyResolved); // Employees can view their resolved
				});
			});
			
		

			

	});
}
}

	 

