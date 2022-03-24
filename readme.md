
# Instrukcje uruchomienia

**startup.bat** - uruchamia system

**build-image-win.bat** - uruchamiony po zmianu pliku .jar (kiedy minikube już działa), aktualizuje docker image i restartuje deployment

**shutdown.bat** - wyłącza system


Po uruchomieniu przez startup.bat należy w ososbnych terminalu uruchomić tunele:

Aby widzieć GUI strony internetowej:
minikube service front-end --namespace="sock-shop"

Aby mieć dostęp do GUI prometheusa:
minikube service prometheus --namespace="monitoring"

Aby mieć dostęp do endpointów dema:
minikube service drools-engine -n="drools-demo"

Ten ostatni należy restartować każdorazowo w przypadku rebuildu przez build-image-win.bat