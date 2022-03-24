powershell -Command "& {minikube -p minikube docker-env --shell powershell | Invoke-Expression; docker build -t prototype_image ./DroolsPrototype}"

kubectl delete -f microservices-demo\deploy\kubernetes\manifests-drools\

kubectl create -f microservices-demo\deploy\kubernetes\manifests-drools\

