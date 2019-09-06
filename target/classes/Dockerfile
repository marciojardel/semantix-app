FROM python:3.7

EXPOSE 8888

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY requirements.txt /usr/src/app/
RUN pip3 install virtualenv
RUN virtualenv -p python3 env
RUN source env/bin/activate
RUN pip install --no-cache-dir -r requirements.txt

ENTRYPOINT ["python3", "blog.py"]
