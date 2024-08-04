module project.cs_documentationmaker {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.ikonli.javafx;

	opens project.doc_maker to javafx.fxml;
	exports project.doc_maker;
}