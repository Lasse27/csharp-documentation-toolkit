/**
 *
 */
module project.cs_documentationmaker {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;

	requires org.controlsfx.controls;
	requires org.kordamp.ikonli.javafx;
	requires org.jetbrains.annotations;
	requires java.desktop;

	opens project.docmaker to javafx.fxml, com.google.gson;
	opens project.docmaker.control to javafx.fxml, com.google.gson;
	opens project.docmaker.model.generation to javafx.fxml, com.google.gson;
	opens project.docmaker.model.structure to javafx.fxml, com.google.gson;
	opens project.docmaker.model.tag to javafx.fxml, com.google.gson;
	opens project.docmaker.utility.serialize to com.google.gson, javafx.fxml;

	exports project.docmaker;
	exports project.docmaker.control;
	exports project.docmaker.model.tag;
	exports project.docmaker.model.generation;
	exports project.docmaker.model.structure;
	exports project.docmaker.utility.mlogger;
	exports project.docmaker.utility.serialize;
}