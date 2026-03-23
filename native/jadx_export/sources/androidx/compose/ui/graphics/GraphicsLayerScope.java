package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* compiled from: GraphicsLayerScope.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00128fX¦\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R\u0018\u00105\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0005\"\u0004\b7\u0010\u0007R\u0018\u00108\u001a\u000209X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b@\u0010\u000bR*\u0010A\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR\u001e\u0010D\u001a\u00020EX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u0018\u0010H\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0005\"\u0004\bJ\u0010\u0007R\u0018\u0010K\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0005\"\u0004\bM\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006NÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@PlacementScopeMarker
/* loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo4352getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    int mo4353getCompositingStrategyNrFUSI();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    long mo4354getSizeNHjbRc();

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo4355getSpotShadowColor0d7_KjU();

    /* renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo4356getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo4357setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo4358setCompositingStrategyaDBOjCE(int i);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo4359setSpotShadowColor8_81llA(long j);

    /* renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo4360setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* compiled from: GraphicsLayerScope.kt */
    /* renamed from: androidx.compose.ui.graphics.GraphicsLayerScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4361$default$getAmbientShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* renamed from: $default$setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m4365$default$setAmbientShadowColor8_81llA(GraphicsLayerScope _this, long ambientShadowColor) {
        }

        /* renamed from: $default$getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4364$default$getSpotShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* renamed from: $default$setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m4367$default$setSpotShadowColor8_81llA(GraphicsLayerScope _this, long spotShadowColor) {
        }

        public static RenderEffect $default$getRenderEffect(GraphicsLayerScope _this) {
            return null;
        }

        public static void $default$setRenderEffect(GraphicsLayerScope _this, RenderEffect renderEffect) {
        }

        /* renamed from: $default$getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m4362$default$getCompositingStrategyNrFUSI(GraphicsLayerScope _this) {
            return CompositingStrategy.INSTANCE.m4275getAutoNrFUSI();
        }

        /* renamed from: $default$setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m4366$default$setCompositingStrategyaDBOjCE(GraphicsLayerScope _this, int compositingStrategy) {
        }

        /* renamed from: $default$getSize-NH-jbRc, reason: not valid java name */
        public static long m4363$default$getSizeNHjbRc(GraphicsLayerScope _this) {
            return Size.INSTANCE.m4022getUnspecifiedNHjbRc();
        }
    }

    /* compiled from: GraphicsLayerScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4391roundToPxR2X_6o(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4392roundToPx0680j_4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4396toDpGaN1DYA(GraphicsLayerScope $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4397toDpu2uoSUM(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4398toDpu2uoSUM(GraphicsLayerScope $this, int $receiver) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4399toDpSizekrfVVM(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4400toPxR2X_6o(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4401toPx0680j_4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(GraphicsLayerScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4402toSizeXkaWNTQ(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4403toSp0xMU5do(GraphicsLayerScope $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4404toSpkPz2Gy4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4405toSpkPz2Gy4(GraphicsLayerScope $this, int $receiver) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4387getAmbientShadowColor0d7_KjU(GraphicsLayerScope $this) {
            return CC.m4361$default$getAmbientShadowColor0d7_KjU($this);
        }

        @Deprecated
        /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m4393setAmbientShadowColor8_81llA(GraphicsLayerScope $this, long ambientShadowColor) {
            CC.m4365$default$setAmbientShadowColor8_81llA($this, ambientShadowColor);
        }

        @Deprecated
        /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4390getSpotShadowColor0d7_KjU(GraphicsLayerScope $this) {
            return CC.m4364$default$getSpotShadowColor0d7_KjU($this);
        }

        @Deprecated
        /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m4395setSpotShadowColor8_81llA(GraphicsLayerScope $this, long spotShadowColor) {
            CC.m4367$default$setSpotShadowColor8_81llA($this, spotShadowColor);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope $this) {
            return CC.$default$getRenderEffect($this);
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope $this, RenderEffect renderEffect) {
            CC.$default$setRenderEffect($this, renderEffect);
        }

        @Deprecated
        /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m4388getCompositingStrategyNrFUSI(GraphicsLayerScope $this) {
            return CC.m4362$default$getCompositingStrategyNrFUSI($this);
        }

        @Deprecated
        /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m4394setCompositingStrategyaDBOjCE(GraphicsLayerScope $this, int compositingStrategy) {
            CC.m4366$default$setCompositingStrategyaDBOjCE($this, compositingStrategy);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4389getSizeNHjbRc(GraphicsLayerScope $this) {
            return CC.m4363$default$getSizeNHjbRc($this);
        }
    }
}
