package com.adastragrp;

public enum accountType {
    current {
        @Override
        public String toString() {
            return "current";
        }
    },
    deposit {
        @Override
        public String toString() {
            return "deposit";
        }
    },
    undefined {
        @Override
        public String toString() {
            return "undefined";
        }
    }
}
