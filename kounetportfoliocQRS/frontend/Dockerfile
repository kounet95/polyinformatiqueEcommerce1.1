# Étape 1 : Construction
FROM node:18 AS build

WORKDIR /usr/local/app

# Copier le code source dans le répertoire de travail
COPY . .

# Installer toutes les dépendances
RUN npm install

# Générer le build de l'application
RUN npm run build

# Étape 2 : Serveur
FROM nginx:latest

# Copier les fichiers construits depuis l'étape 1
COPY --from=build /usr/local/app/build /usr/share/nginx/html

# Exposer le port 80
EXPOSE 80

# Démarrer nginx
CMD ["nginx", "-g", "daemon off;"]