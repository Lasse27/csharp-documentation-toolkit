package project.docmaker.utility.mlogger;


import java.lang.annotation.*;


/**
 * Marker-annotation-interface which is used to turn off warnings about {@link Logger} instances missing in model classes.
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@Inherited
@Target (ElementType.TYPE)
@Retention (RetentionPolicy.RUNTIME)
public @interface NoLogger
{}
