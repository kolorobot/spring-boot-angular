"use strict";

let gulp = require("gulp");
let del = require("del");
let tsc = require("gulp-typescript");
let sourcemaps = require('gulp-sourcemaps');
let tsProject = tsc.createProject("tsconfig.json");
let tslint = require('gulp-tslint');

/**
 * Remove build directory.
 */
gulp.task('clean', (cb) => {
    return del(["build"], cb);
});

/**
 * Lint all custom TypeScript files.
 */
gulp.task('tslint', () => {
    return gulp.src("src/**/*.ts")
        .pipe(tslint())
        .pipe(tslint.report('prose'));
});

/**
 * Compile TypeScript sources and create sourcemaps in build directory.
 */
gulp.task("compile", ["tslint"], () => {
    let tsResult = gulp.src("src/**/*.ts")
        .pipe(sourcemaps.init())
        .pipe(tsc(tsProject));
    return tsResult.js
        .pipe(sourcemaps.write("."))
        .pipe(gulp.dest("build"));
});

/**
 * Copy all resources that are not TypeScript files into build directory (including external).
 */
gulp.task("resources", () => {
    // copy Bootstrap resources (css and fonts)
    gulp.src(["node_modules/bootstrap/**/css/*", "node_modules/bootstrap/**/fonts/*"])
        .pipe(gulp.dest("build/lib/bootstrap"));

    return gulp.src(["src/**/*", "!**/*.ts",]).pipe(gulp.dest("build"));
});

/**
 * Copy all required libraries into build directory.
 */
gulp.task("libs", () => {
    return gulp.src([
            'jquery/dist/jquery.js',
            'bootstrap/dist/js/bootstrap.js',
            'angular/angular.js',
            'angular-ui-router/release/angular-ui-router.js'
        ], {cwd: "node_modules/**"}) /* Glob required here. */
        .pipe(gulp.dest("build/lib"));
});

/**
 * Watch for changes in TypeScript, HTML and CSS files.
 */
gulp.task('watch', function () {
    gulp.watch(["src/**/*.ts"], ['compile']).on('change', function (e) {
        console.log('TypeScript file ' + e.path + ' has been changed. Compiling.');
    });
    gulp.watch(["src/**/*.html", "src/**/*.css"], ['resources']).on('change', function (e) {
        console.log('Resource file ' + e.path + ' has been changed. Updating.');
    });
});

/**
 * Build the project.
 */
gulp.task("build", ['compile', 'resources', 'libs'], () => {
    console.log("Building the project ...");
});