#------------------------------------------------------------------------------
# Yet another Makefile with macros
#------------------------------------------------------------------------------
JAVASRC  = HelloUser.java HelloUser2.java
SOURCES    = README makefile $(JAVASRC)
MAINCLASS  = HelloUser2
CLASSES    = HelloUser.class HelloUser2.class
JARFILE    = Hello
SUBMIT     = submit cmps012b-pt.w19 lab1

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
	
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)