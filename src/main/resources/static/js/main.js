import * as THREE from "https://threejsfundamentals.org/threejs/resources/threejs/r122/build/three.module.js";
import { OrbitControls } from "https://threejsfundamentals.org/threejs/resources/threejs/r122/examples/jsm/controls/OrbitControls.js";
import { GLTFLoader } from 'https://threejsfundamentals.org/threejs/resources/threejs/r122/examples/jsm/loaders/GLTFLoader.js';
import { SkeletonUtils } from 'https://threejsfundamentals.org/threejs/resources/threejs/r122/examples/jsm/utils/SkeletonUtils.js';
import * as TWEEN from 'https://cdnjs.cloudflare.com/ajax/libs/tween.js/18.6.4/tween.umd.js';

class AnimalIsland {

    parentScene;
    manager;
    models;
    canvas;
    renderer;
    camera;
    then;
    mixers;
    mixerInfos;
    
    island;
    islandModels;

    cloudModels;

    constructor(parent, name){
        this.canvas = document.querySelector("#reborn-island");
        this.renderer = new THREE.WebGLRenderer({ 
			canvas: this.canvas, 
  			logarithmicDepthBuffer: true, 
			antialias: true
		});
        this.parentScene = parent;
        this.manager = new THREE.LoadingManager();
        this.then = 0;
        this.mixers = [];
        this.mixerInfos = [];
        this.islandModels = {};
        this.cloudModels = [];

        const fov = 45;
        const aspect = 2; // the canvas default
        const near = 0.1;
        const far = 20000;
        this.camera = new THREE.PerspectiveCamera(fov, aspect, near, far);
        this.camera.position.set(15, 25, 35);
//        this.camera.position.set(150, 125, 175);
        
        const controls = new OrbitControls(this.camera, this.renderer.domElement);
        controls.target.set(0, 4, 0);
        controls.update();
		this.camera.position.set(15+90, 25+90, 35+180);

        const light1  = new THREE.AmbientLight(0xffffff, 0.3);
        light1.position.set(1.5, 2, 1.866); // ~60º
        light1.name = 'ambient_light';
        this.parentScene.add( light1 );
    
        const light2  = new THREE.DirectionalLight(0xffffff, 1.5);
        light2.position.set(1.5, 3, 1.866); // ~60º
        light2.name = 'main_light';
        this.parentScene.add( light2 );

        this.parentScene.background = new THREE.Color('#DEFEFF');
        // this.renderer.shadowMap.enabled = true;
        this.renderer.outputEncoding = THREE.sRGBEncoding;

        this.models = {
            pig:    { url: '/models/animals/Pig.gltf' },
            cow:    { url: '/models/animals/Cow.gltf' },
            llama:  { url: '/models/animals/Llama.gltf' },
            pug:    { url: '/models/animals/Pug.gltf' },
            sheep:  { url: '/models/animals/Sheep.gltf' },
            zebra:  { url: '/models/animals/Zebra.gltf' },
            horse:  { url: '/models/animals/Horse.gltf' },
            // knight: { url: '/models/knight/KnightCharacter.gltf' },
        };
        {
            const gltfLoader = new GLTFLoader(this.manager);
            for (const model of Object.values(this.models)) {
                gltfLoader.load(model.url, (gltf) => {
                    model.gltf = gltf;
                    gltf.scene.position.set(0, 4, 0);
                    gltf.scene.scale.set(0.45, 0.45, 0.45);
                });
            }

            gltfLoader.load('/models/easter_island_low_poly/scene.gltf', (gltf) => {
                let model = gltf.scene;
                model.scale.set(1,1,1);
                model.position.set(-2, -5, -2);

                let cloudObjects = model.getObjectByName('Nuvem');

                this.islandModels = {
                    cloudObjects,
                    smokeObjects: model.getObjectByName('Fuma��a'),
                    RaftObject: model.getObjectByName('Barco'),
                    TreeObjects: model.getObjectByName('Arvere')
                }

                for (const cloudObject of cloudObjects.children) {
                    cloudObject.position.x = (Math.random() * 75) - 40;
                    cloudObject.position.z = (Math.random() * 60) - 30;
                }
                this.parentScene.add(model);
            });
        }

        {
            let loader = new THREE.TextureLoader();
            loader.load("/images/smoke-1.png", (texture)=>{
                let cloudGeo = new THREE.PlaneBufferGeometry(500,500);
                let cloudMaterial = new THREE.MeshLambertMaterial({
                    map: texture,
                    transparent: true
                });

                for(let i=0; i<10; i++) {
                    let cloud = new THREE.Mesh(cloudGeo, cloudMaterial);
                    cloud.position.set(
                        Math.random()*25 + 25,
                        Math.random()*10 + 50,
                        Math.random()*2 + 20
                    );
                    cloud.rotation.x = THREE.Math.degToRad(-45);
                    cloud.rotation.y = 0.5;
                    cloud.rotation.z = Math.random() * 2 * Math.PI;
                    cloud.material.opacity = 1;
					cloud.name = `cloudModel${i}`;
                    this.cloudModels.push(cloud);
                    this.parentScene.add(cloud);
                }
            });
        }

        this.manager.onLoad = this.init.bind(this);
        const progressbarElem = document.querySelector('.progress');
        this.manager.onProgress = (url, itemsLoaded, itemsTotal) => {
            progressbarElem.innerText = `${ itemsLoaded / itemsTotal * 100 | 0 }%`;
        };
//        const progressbarElem = document.querySelector('#progressbar');
//        this.manager.onProgress = (url, itemsLoaded, itemsTotal) => {
//            progressbarElem.style.width = `${ itemsLoaded / itemsTotal * 100 | 0 }%`;
//        };
    }


    prepModelsAndAnimations() {
        Object.values(this.models).forEach(model => {
            const animsByName = {};
            model.gltf.animations.forEach((clip) => {
                animsByName[clip.name] = clip;
            });
            model.animations = animsByName;
        });
    }

    addLight(...pos) {
        const color = 0xFFFFFF;
        const intensity = 1;
        const light = new THREE.DirectionalLight(color, intensity);
        light.position.set(...pos);
        this.parentScene.add(light);
        this.parentScene.add(light.target);
    }

    init(){
        const loadingElem = document.querySelector('#loading');
		const greetingElem = document.querySelector('#animal');
        
        setTimeout(()=>{
			loadingElem.style = {
				"-webkit-backdrop-filter": "blur(0)",
				"backdropFilter": "blur(0)"
			}
			loadingElem.style.opacity = "0";
			greetingElem.style.opacity = "0";
			let repeat = 180;
			let cnt = 0;
			let interval = setInterval(()=>{
//				console.log(cnt);
				
				this.cloudModels.forEach(
					(cloud, ndx) => {
						if( ndx % 2 == 0)
							cloud.position.x += 2;
						else 
							cloud.position.x -= 2;
                    	cloud.material.opacity = 1-cnt/repeat;
					}
				)
				if( cnt >= repeat ){
					this.cloudModels.forEach(
						cloud => this.parentScene.remove(cloud)	
					)
					greetingElem.classList.remove("d-none");
					setTimeout(()=>{
						greetingElem.style.opacity = "1";
					},10);		
					loadingElem.remove("d-none");
					this.cloudModels = [];
					clearInterval(interval);
				}
				let {x, y, z} = this.camera.position;
				this.camera.position.set(x - 0.5, y - 0.5 , z - 1);
				
				cnt++;
			}, 1000/60);
		},2000);
        this.prepModelsAndAnimations();

        let modelScenes = [];
        Object.values(this.models).forEach((model, ndx) => {
            const clonedScene = SkeletonUtils.clone(model.gltf.scene);
            const root = new THREE.Object3D();
            root.add(clonedScene);
            this.parentScene.add(root);
            let x = Math.random() * 30 - 15;
            let z = Math.random() * 20 - 5;
            let newDeg = Math.floor(Math.random() * 360);
            root.position.set(x, 0, z);
            root.rotation.y = THREE.Math.degToRad(newDeg);
            modelScenes.push(root);

            const mixer = new THREE.AnimationMixer(clonedScene);
            // const firstClip = Object.values(model.animations)[0];
            // const action = mixer.clipAction(firstClip);
            // action.play();
            // this.mixers.push(mixer);

            const actions = Object.values(model.animations).map(
                clip => mixer.clipAction(clip)
            );

            const mixerInfo = {
                mixer,
                actions,
                actionNdx: -1,
            };
            this.mixerInfos.push(mixerInfo);
            
            setTimeout(()=>{
                actions.forEach((action, ndx) => {
                    const enabled = action.getClip().name == "WalkSlow";
                    action.enabled = enabled;
                    if( enabled ){
                        mixerInfo.actionNdx = ndx;
                        action.reset();
                        action.play();
                    }
                });
            });
        });
        this.animalModels = modelScenes;
                
        window.addEventListener('keydown', (e) => {
            const mixerInfo = this.mixerInfos[e.keyCode - 49];
            if (!mixerInfo) {
                return;
            }
            this.playNextAction(mixerInfo);
        });
        this.render();
    }

    degToVector(deg){
        let x, z;

        if( deg <= 90){
            z = 1 - (deg/90);
            x = 1 - z;
        } else if( deg <= 180 ){
            x = 1 - ((deg-90)/90);
            z = -(1 - x);
        } else if( deg <= 270 ){
            z = -(1 - ((deg-180)/90));
            x = -(1 + z);
        } else if( deg <= 360 ){
            x = -(1 - ((deg-270)/90));
            z = 1 + x;
        }

        return {x, z};
    }

    playNextAction(mixerInfo) {
        const { actions, actionNdx } = mixerInfo;
        const nextActionNdx = (actionNdx + 1) % actions.length;
        mixerInfo.actionNdx = nextActionNdx;
        actions.forEach((action, ndx) => {
            const enabled = ndx === nextActionNdx;
            action.enabled = enabled;
            if (enabled) {
                action.play();
            }
        });
    }

    render(now) {
        now *= 0.001;  // 초 단위로 변환
        const deltaTime = now - this.then;
        this.then = now;

        if (this.resizeRendererToDisplaySize(this.renderer)) {
            const canvas = this.renderer.domElement;
            this.camera.aspect = canvas.clientWidth / canvas.clientHeight;
            this.camera.updateProjectionMatrix();
        }

		if(this.cloudModels.length != 0){
			this.cloudModels.forEach(
				cloud => {
					cloud.rotation.z += 0.003;
				}
			)
		}

        for (const { mixer } of this.mixerInfos) {
            mixer.update(deltaTime);
        }
        // this.camera.position.x += 0.1;
        this.animalModels.forEach(
            scene => {
                
                let originDeg = THREE.Math.radToDeg(scene.rotation.y);
                let {x: originX, y: originY, z: originZ} = scene.position;

                let {x: newX, z: newZ} = this.degToVector(originDeg);
                newX = newX * 0.015 + originX;
                newZ = newZ * 0.015 + originZ;


                if( newX < -16 || 18 < newX || newZ < -5 || 22 < newZ ){
//                    console.log("out");
                    scene.rotation.y = THREE.Math.degToRad(Math.floor(Math.random() * 360));
                    return;
                }

                scene.position.set(newX, originY, newZ);

                if( Math.random() < 0.9995)
                    return;
                
                let newDeg = Math.floor(Math.random() * 360);
                scene.rotation.y = THREE.Math.degToRad(newDeg);
            }
        )

        let { smokeObjects, cloudObjects } = this.islandModels;

        for (const smokeObject of smokeObjects.children) {
            smokeObject.position.y = smokeObject.position.y * 1.001;
            if( smokeObject.position.y > 25){
                smokeObject.position.y = 15;
            }
        }

        for (const cloudObject of cloudObjects.children) {
            cloudObject.position.x = cloudObject.position.x + 0.02;
            
            if( cloudObject.position.x > 40){
                cloudObject.position.x = -40;
                cloudObject.position.z = (Math.random() * 60) - 30;
            }
        }
        
        this.renderer.render(this.parentScene, this.camera);
        window.requestAnimationFrame(this.render.bind(this));
    }

    dumpObject(obj) {
        console.group(' <' + obj.type + '> ' + obj.name);
        obj.children.forEach((child) => dumpObject(child));
        console.groupEnd();
    }

    resizeRendererToDisplaySize(renderer) {
        // const canvas = this.renderer.domElement;
        // this.camera.aspect = canvas.clientWidth / canvas.clientHeight;
        // this.renderer.setSize(window.innerWidth, window.innerHeight);
        // this.camera.updateProjectionMatrix();
        const canvas = renderer.domElement;
        const width = canvas.clientWidth;
        const height = canvas.clientHeight;
        const needResize = canvas.width !== width || canvas.height !== height;
        if (needResize) {
            renderer.setSize(width, height, false);
        }
        return needResize;
    }


}

let scene = new THREE.Scene();
export default new AnimalIsland(scene, 'animalIsland');

// function main() {
//     const canvas = document.querySelector("#c");
//     const renderer = new THREE.WebGLRenderer({ canvas });

//     const fov = 45;
//     const aspect = 2; // the canvas default
//     const near = 0.1;
//     const far = 20000;
//     const camera = new THREE.PerspectiveCamera(fov, aspect, near, far);
//     camera.position.set(20, 30, 40);
    
//     const controls = new OrbitControls(camera, renderer.domElement);
//     controls.target.set(0, 0, 0);
//     controls.update();

//     const scene = new THREE.Scene();

//     {
//         const color = 0xffffff;
//         const intensity = 1;


//         const light1  = new THREE.AmbientLight(0xffffff, 0.3);
//         light1.position.set(1.5, 2, 1.866); // ~60º
//         light1.name = 'ambient_light1';
//         scene.add( light1 );
    
//         const light2  = new THREE.DirectionalLight(0xffffff, 1.5);
//         light2.position.set(1.5, 3, 1.866); // ~60º
//         light2.name = 'main_light';
//         scene.add( light2 );


//         // const hemiLight = new THREE.HemisphereLight( 0x0000ff, 0x0000ff, 0.2 ); 
//         // hemiLight.position.set( -10, 100, -10 );
//         // scene.add( hemiLight );
    
//     }

//     const radius = 10.0;
//     const widthSegments = 100;
//     const heightSegments = 100;
//     const geometry = new THREE.SphereBufferGeometry(
//         radius,
//         widthSegments,
//         heightSegments
//     );

//     {
//         // const loader = new THREE.CubeTextureLoader();
//         // const texture = loader.load([
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/pos-x.jpg",
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/neg-x.jpg",
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/pos-y.jpg",
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/neg-y.jpg",
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/pos-z.jpg",
//         //     "https://threejsfundamentals.org/threejs/resources/images/cubemaps/computer-history-museum/neg-z.jpg",
//         // ]);
//         // scene.background = texture;
//     }

//     let gltfLoader = new GLTFLoader();

//     function dumpObject(obj) {
//         console.group(' <' + obj.type + '> ' + obj.name);
//         obj.children.forEach((child) => dumpObject(child));
//         console.groupEnd();
//     }

//     let smokeObjects, cloudObjects, RaftObject, TreeObjects;
//     gltfLoader.load('model/easter_island_low_poly/scene.gltf', function(model){
//         let root = model.scene;
//         // console.log(model.scene)r
//         root.scale.set(1,1,1);
//         root.position.set(0, 0, 0);
//         scene.add(root);

//         smokeObjects = root.getObjectByName('Fuma��a');
//         RaftObject = root.getObjectByName('Barco');
//         cloudObjects = root.getObjectByName('Nuvem');
//         TreeObjects = root.getObjectByName('Arvere');

//     });
//     const animalModels = [
//         'pig',
//         'cow',
//         'llama',
//         'pug',
//         'sheep',
//         'zebra',
//         'horse',
//     ];
//     gltfLoader.load('Horse.gltf', function(model){
//         let root = model.scene.children[0];

//         root.scale.set(0.5,0.5,0.5);
//         root.position.set(0, 10, 0);
//         scene.add(root);

//         root.traverse((obj) => {
//             if (obj.castShadow !== undefined) {
//               obj.castShadow = true;
//               obj.receiveShadow = true;
//             }
//         });
//         console.log(dumpObject(root));
//     });

//     function resizeRendererToDisplaySize(renderer) {
//         const canvas = renderer.domElement;
//         const width = canvas.clientWidth;
//         const height = canvas.clientHeight;
//         const needResize = canvas.width !== width || canvas.height !== height;
//         if (needResize) {
//             renderer.setSize(width, height, false);
//         }
//         return needResize;
//     }


//     renderer.shadowMap.enabled = true;
//     scene.background = new THREE.Color('#DEFEFF');
//     renderer.outputEncoding = THREE.sRGBEncoding;

//     function render(time) {
//         time *= 0.001;

//         if (resizeRendererToDisplaySize(renderer)) {
//             const canvas = renderer.domElement;
//             camera.aspect = canvas.clientWidth / canvas.clientHeight;
//             camera.updateProjectionMatrix();
//         }

//         renderer.render(scene, camera);

//         if (smokeObjects) {
//             for (const smokeObject of smokeObjects.children) {
//                 smokeObject.position.y = smokeObject.position.y * 1.001;
//                 if( smokeObject.position.y > 25){
//                     smokeObject.position.y = 15;
//                 }
//             }
//         }

//         if (cloudObjects) {
//             for (const cloudObject of cloudObjects.children) {
//                 cloudObject.position.x = cloudObject.position.x + 0.02;
                
//                 if( cloudObject.position.x > 35){
//                     cloudObject.position.x = -40;
//                     cloudObject.position.z = (Math.random() * 60) - 30;
//                 }
//             }
//         }

//         // if(TreeObjects){
//         //     for (const TreeObject of TreeObjects.children) {
//         //         TreeObject.position.x = TreeObject.position.x + (Math.random() / 20.0);
                
//         //         if( TreeObject.position.x > 35){
//         //             TreeObject.position.x = -40;
//         //             TreeObject.position.z = (Math.random() * 60) - 30;
//         //         }
//         //     }
//         // }
//         // if (RaftObject)
//         // RaftObject.rotation.y = (Math.random() / 10.0);

//         // console.log(time)

//         requestAnimationFrame(render);
//     }

//     requestAnimationFrame(render);
// }

// main();
