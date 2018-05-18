package com.poc.jersey.controller;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import com.poc.jersey.dto.FormData;

@Path("/")
@Component
public class MasterController {
	
	@GET
	public String master() {
		return "MASTER";
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String saveRecall(
			@FormDataParam("file") InputStream file,
			@FormDataParam("file") FormDataContentDisposition fileDisposition,
			@FormDataParam("formData") FormData recallDto) {
		return fileDisposition.getFileName();
	}

}
