package com.adastragrp;

public class Main {

    public static void main(String[] args) {

    }

    public class Entity {

    }

    public class EventInterceptor {

    }

    //Refactored Code

    public interface Event {
        void interceptEvent(Entity entity);
    }

    public class PreLoad implements Event {
        @Override
        public void interceptEvent(Entity entity) {

        }
    }

    public class PostLoad implements Event {
        @Override
        public void interceptEvent(Entity entity) {

        }
    }

    public class PrePersist implements Event {
        @Override
        public void interceptEvent(Entity entity) {

        }
    }

    public class PreSave implements Event {
        @Override
        public void interceptEvent(Entity entity) {

        }
    }

    public class PostPersist implements Event {
        @Override
        public void interceptEvent(Entity entity) {

        }
    }
    public class EventHandler {
        private Entity entity;
        private EventInterceptor ei;

        public void handleEvent(Event event) {
            event.interceptEvent(entity);
        }
    }

    // given code snippet

//    public class EventHandler {
//        private Object entity;
//        private EventInterceptor ei;
//
//        public void handleEvent(Event event) {
//            if (event instanceof PreLoad) {
//                ei.preLoad(entity);
//            } else if (event instanceof PostLoad) {
//                ei.postLoad(entity);
//            } else if (event instanceof PrePersist) {
//                ei.prePersist(entity);
//            } else if (event instanceof PreSave) {
//                ei.preSave(entity);
//            } else if (event instanceof PostPersist) {
//                ei.postPersist(entity);
//            }
//        }
//    }
}
