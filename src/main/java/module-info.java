module project.cs_documentationmaker {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.ikonli.javafx;

	opens project.docmaker to javafx.fxml;
	exports project.docmaker;
}