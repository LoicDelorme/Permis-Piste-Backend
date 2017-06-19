FROM nginx:alpine

COPY src/ /usr/share/nginx/html
COPY frontend.conf.template /etc/nginx/conf.d/frontend.conf.template
COPY run.sh /run.sh

CMD ["/bin/sh", "/run.sh"]