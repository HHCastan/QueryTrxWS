#Root logger a info para que no moleste
log4j.rootLogger = WARN
#logger para el PEF
log4j.logger.com.fal = DEBUG, pef
log4j.logger.com.linea.posappEnginePromotions = DEBUG, pef
log4j.logger.com.lineai.posappframework = DEBUG, pef
log4j.logger.error.com.fal = ERROR, pefErr
log4j.logger.error.com.linea.posappEnginePromotions = ERROR, pefErr
log4j.logger.error.com.lineai.posappframework = ERROR, pefErr
#log4j.additivity.com.linea.posappEnginePromotions = false
#log4j.additivity.com.fal = false
#log4j.additivity.com.lineai.posappframework = false
#Configuracion del appender
log4j.appender.pef = org.apache.log4j.RollingFileAppender
log4j.appender.pef.File=${pef.log}
log4j.appender.pef.MaxFileSize=1MB
# Keep one backup file
log4j.appender.pef.MaxBackupIndex=10
log4j.appender.pef.layout=org.apache.log4j.PatternLayout
log4j.appender.pef.layout.ConversionPattern=<%p><%d{ISO8601}>%m%n
#Para errores
log4j.appender.pefErr = org.apache.log4j.RollingFileAppender
log4j.appender.pefErr.File=${pefErr.log}
log4j.appender.pefErr.MaxFileSize=1MB
# Keep one backup file
log4j.appender.pefErr.MaxBackupIndex=10
log4j.appender.pefErr.layout=org.apache.log4j.PatternLayout
log4j.appender.pefErr.layout.ConversionPattern=<%p><%d{ISO8601}>%m%n