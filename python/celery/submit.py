# -*- coding: utf-8 -*-
import app
import config

# app.celery.conf.update(config.config)

# while True:
app.celery.send_task(
        'app.add',
        args=(1, 2, 3),
    )


# while True:
app.celery.send_task(
        'slow.demo',
        args=(1, 2, 3),
    )
