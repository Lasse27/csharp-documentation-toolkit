module project.cs_documentationmaker {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.ikonli.javafx;
	requires org.jetbrains.annotations;
	requires com.aspose.words;

	opens project.docmaker to javafx.fxml;
	exports project.docmaker;
}