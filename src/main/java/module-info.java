module project.cs_documentationmaker {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.ikonli.javafx;
	requires org.jetbrains.annotations;

	opens project.docmaker to javafx.fxml;
	opens project.docmaker.control to javafx.fxml;
	exports project.docmaker;
	exports project.docmaker.control;
	exports project.docmaker.model.structure;
	exports project.docmaker.model.structure.section;
	exports project.docmaker.model.structure.section.implementation;
	exports project.docmaker.utility;
	opens project.docmaker.utility to javafx.fxml;
}