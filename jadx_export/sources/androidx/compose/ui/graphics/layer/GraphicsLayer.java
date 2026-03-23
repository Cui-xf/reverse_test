package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ¶\u00012\u00020\u0001:\u0002¶\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0085\u0001\u001a\u0002082\u0007\u0010\u0086\u0001\u001a\u00020\u0000H\u0002J\t\u0010\u0087\u0001\u001a\u000208H\u0002J\t\u0010\u0088\u0001\u001a\u000208H\u0002J\u000f\u0010\u0089\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u008a\u0001J$\u0010\u008b\u0001\u001a\u0002082\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u0002082\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000¢\u0006\u0003\b\u0091\u0001J\u000f\u0010\u0092\u0001\u001a\u000208H\u0001¢\u0006\u0003\b\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0095\u0001\u001a\u000208H\u0002J\t\u0010\u0096\u0001\u001a\u000208H\u0002JE\u0010\u0097\u0001\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010r\u001a\u00020q2\u0018\u0010\u0098\u0001\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\t\u0010\u009b\u0001\u001a\u000208H\u0002J\t\u0010\u009c\u0001\u001a\u000208H\u0002J\u000f\u0010\u009d\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u009e\u0001J\t\u0010\u009f\u0001\u001a\u000208H\u0002J5\u0010 \u0001\u001a\u0003H¡\u0001\"\u0005\b\u0000\u0010¡\u00012\u001b\u0010\u0098\u0001\u001a\u0016\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020f\u0012\u0005\u0012\u0003H¡\u00010¢\u0001H\u0082\b¢\u0006\u0003\u0010£\u0001J\u0010\u0010¤\u0001\u001a\u0002082\u0007\u0010¥\u0001\u001a\u00020JJ%\u0010¦\u0001\u001a\u0002082\u0006\u0010{\u001a\u00020z2\u0006\u0010r\u001a\u00020qH\u0002ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J'\u0010©\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020fø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010¨\u0001J2\u0010«\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020f2\t\b\u0002\u0010¬\u0001\u001a\u00020\bø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0011\u0010¯\u0001\u001a\u00030°\u0001H\u0086@¢\u0006\u0003\u0010±\u0001J\u0013\u0010²\u0001\u001a\u0002082\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0012\u0010µ\u0001\u001a\u00020\u00152\u0007\u0010¥\u0001\u001a\u00020JH\u0002R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020!8F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0007\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020/8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u00105\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010E\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bL\u0010\u0011R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010P\u001a\u00020O2\u0006\u0010\u0007\u001a\u00020O@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R(\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0007\u001a\u0004\u0018\u00010T8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u000b\"\u0004\b\\\u0010\rR$\u0010]\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u000b\"\u0004\b_\u0010\rR$\u0010`\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u000b\"\u0004\bb\u0010\rR\u0010\u0010c\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR\u0016\u0010g\u001a\u00020OX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR$\u0010h\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR$\u0010n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000b\"\u0004\bp\u0010\rR,\u0010r\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bs\u0010\u0011\"\u0004\bt\u0010\u0013R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010w\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010\u0013R,\u0010{\u001a\u00020z2\u0006\u0010\u0007\u001a\u00020z@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\b|\u0010\u0011\"\u0004\b}\u0010\u0013R%\u0010~\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u000b\"\u0005\b\u0080\u0001\u0010\rR'\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010\u000b\"\u0005\b\u0083\u0001\u0010\rR\u000f\u0010\u0084\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006·\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "androidOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "clip", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "<set-?>", "isReleased", "layerId", "", "getLayerId", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outlineDirty", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "ownerViewId", "getOwnerViewId", "parentLayerUsages", "", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "J", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "roundRectClipPath", "roundRectCornerRadius", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectOutlineTopLeft", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "setTopLeft--gyyYBs", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "usePathForClip", "addSubLayer", "graphicsLayer", "configureOutline", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "draw$ui_graphics_release", "drawForPersistence", "drawForPersistence$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "obtainAndroidOutline", "onAddedToParentLayer", "onRemovedFromParentLayer", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "recreateDisplayListIfNeeded", "release", "release$ui_graphics_release", "resetOutlineParams", "resolveOutlinePosition", "T", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setPathOutline", "path", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "setRectOutline", "setRectOutline-tz77jQw", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "updatePathOutline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private final LayerManager layerManager;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope $this$null) {
        }
    };
    private boolean outlineDirty = true;
    private long roundRectOutlineTopLeft = Offset.INSTANCE.m3961getZeroF1C5BW0();
    private long roundRectOutlineSize = Size.INSTANCE.m4022getUnspecifiedNHjbRc();
    private final ChildLayerDependenciesTracker childDependenciesTracker = new ChildLayerDependenciesTracker();

    /* compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {847}, m = "toImageBitmap", n = {}, s = {})
    /* renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphicsLayer.this.toImageBitmap(this);
        }
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    public GraphicsLayer(GraphicsLayerImpl impl, LayerManager layerManager) {
        this.impl = impl;
        this.layerManager = layerManager;
        this.impl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m6835getZeronOccac();
        this.size = IntSize.INSTANCE.m6872getZeroYbymL2g();
        this.pivotOffset = Offset.INSTANCE.m3960getUnspecifiedF1C5BW0();
    }

    /* renamed from: getImpl$ui_graphics_release, reason: from getter */
    public final GraphicsLayerImpl getImpl() {
        return this.impl;
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m4839getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m4847setCompositingStrategyWpw9cng(int value) {
        if (!CompositingStrategy.m4826equalsimpl0(this.impl.getCompositingStrategy(), value)) {
            this.impl.mo4860setCompositingStrategyWpw9cng(value);
        }
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m4852setTopLeftgyyYBs(long value) {
        if (!IntOffset.m6824equalsimpl0(this.topLeft, value)) {
            this.topLeft = value;
            m4833setPositionVbeCjmY(value, this.size);
        }
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m4836setSizeozmzZPI(long value) {
        if (!IntSize.m6865equalsimpl0(this.size, value)) {
            this.size = value;
            m4833setPositionVbeCjmY(this.topLeft, value);
            long $this$isUnspecified$iv = this.roundRectOutlineSize;
            if ($this$isUnspecified$iv == InlineClassHelperKt.UnspecifiedPackedFloats) {
                this.outlineDirty = true;
                configureOutline();
            }
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float value) {
        if (!(this.impl.getAlpha() == value)) {
            this.impl.setAlpha(value);
        }
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4838getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m4846setBlendModes9anfk8(int value) {
        if (!BlendMode.m4098equalsimpl0(this.impl.getBlendMode(), value)) {
            this.impl.mo4859setBlendModes9anfk8(value);
        }
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final void setColorFilter(ColorFilter value) {
        if (!Intrinsics.areEqual(this.impl.getColorFilter(), value)) {
            this.impl.setColorFilter(value);
        }
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m4848setPivotOffsetk4lQ0M(long value) {
        if (!Offset.m3942equalsimpl0(this.pivotOffset, value)) {
            this.pivotOffset = value;
            this.impl.mo4861setPivotOffsetk4lQ0M(value);
        }
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float value) {
        if (!(this.impl.getScaleX() == value)) {
            this.impl.setScaleX(value);
        }
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float value) {
        if (!(this.impl.getScaleY() == value)) {
            this.impl.setScaleY(value);
        }
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float value) {
        if (!(this.impl.getTranslationX() == value)) {
            this.impl.setTranslationX(value);
        }
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float value) {
        if (!(this.impl.getTranslationY() == value)) {
            this.impl.setTranslationY(value);
        }
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float value) {
        if (!(this.impl.getShadowElevation() == value)) {
            this.impl.setShadowElevation(value);
            this.impl.setClip(getClip() || value > 0.0f);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float value) {
        if (!(this.impl.getRotationX() == value)) {
            this.impl.setRotationX(value);
        }
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float value) {
        if (!(this.impl.getRotationY() == value)) {
            this.impl.setRotationY(value);
        }
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float value) {
        if (!(this.impl.getRotationZ() == value)) {
            this.impl.setRotationZ(value);
        }
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final void setCameraDistance(float value) {
        if (!(this.impl.getCameraDistance() == value)) {
            this.impl.setCameraDistance(value);
        }
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean value) {
        if (this.impl.getClip() != value) {
            this.impl.setClip(value);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final void setRenderEffect(RenderEffect value) {
        if (!Intrinsics.areEqual(this.impl.getRenderEffect(), value)) {
            this.impl.setRenderEffect(value);
        }
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m4833setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo4862setPositionH0pRuoY(IntOffset.m6825getXimpl(topLeft), IntOffset.m6826getYimpl(topLeft), size);
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m4844recordmLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        m4836setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void recordInternal() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.recordInternal():void");
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        Canvas androidCanvas2;
        float left = IntOffset.m6825getXimpl(this.topLeft);
        float top = IntOffset.m6826getYimpl(this.topLeft);
        float right = IntOffset.m6825getXimpl(this.topLeft) + IntSize.m6867getWidthimpl(this.size);
        float bottom = IntOffset.m6826getYimpl(this.topLeft) + IntSize.m6866getHeightimpl(this.size);
        float layerAlpha = getAlpha();
        ColorFilter layerColorFilter = getColorFilter();
        int layerBlendMode = m4838getBlendMode0nO6VwU();
        boolean useSaveLayer = layerAlpha < 1.0f || !BlendMode.m4098equalsimpl0(layerBlendMode, BlendMode.INSTANCE.m4129getSrcOver0nO6VwU()) || layerColorFilter != null || CompositingStrategy.m4826equalsimpl0(m4839getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m4832getOffscreenke2Ky5w());
        if (useSaveLayer) {
            Paint it = this.softwareLayerPaint;
            if (it == null) {
                it = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = it;
            }
            Paint it2 = it;
            it2.setAlpha(layerAlpha);
            it2.mo4065setBlendModes9anfk8(layerBlendMode);
            it2.setColorFilter(layerColorFilter);
            Paint paint = it;
            androidCanvas2 = androidCanvas;
            androidCanvas2.saveLayer(left, top, right, bottom, paint.getInternalPaint());
        } else {
            androidCanvas2 = androidCanvas;
            androidCanvas2.save();
        }
        androidCanvas2.translate(left, top);
        androidCanvas2.concat(this.impl.calculateMatrix());
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    private final void recreateDisplayListIfNeeded() {
        if (!this.impl.getHasDisplayList()) {
            try {
                recordInternal();
            } catch (Throwable th) {
            }
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        if (this.isReleased) {
            return;
        }
        recreateDisplayListIfNeeded();
        configureOutline();
        boolean willClipPath = true;
        boolean useZ = getShadowElevation() > 0.0f;
        if (useZ) {
            canvas.enableZ();
        }
        Canvas androidCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean softwareRendered = !androidCanvas.isHardwareAccelerated();
        if (softwareRendered) {
            androidCanvas.save();
            transformCanvas(androidCanvas);
        }
        if (!this.usePathForClip && (!softwareRendered || !getClip())) {
            willClipPath = false;
        }
        if (willClipPath) {
            canvas.save();
            androidx.compose.ui.graphics.Outline tmpOutline = getOutline();
            if (tmpOutline instanceof Outline.Rectangle) {
                Canvas.CC.m4161clipRectmtrdDE$default(canvas, tmpOutline.getRect(), 0, 2, null);
            } else if (tmpOutline instanceof Outline.Rounded) {
                Path rRectPath = this.roundRectClipPath;
                if (rRectPath != null) {
                    rRectPath.rewind();
                } else {
                    rRectPath = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = rRectPath;
                }
                Path.CC.addRoundRect$default(rRectPath, ((Outline.Rounded) tmpOutline).getRoundRect(), null, 2, null);
                Canvas.CC.m4159clipPathmtrdDE$default(canvas, rRectPath, 0, 2, null);
            } else if (tmpOutline instanceof Outline.Generic) {
                Canvas.CC.m4159clipPathmtrdDE$default(canvas, ((Outline.Generic) tmpOutline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (willClipPath) {
            canvas.restore();
        }
        if (useZ) {
            canvas.disableZ();
        }
        if (softwareRendered) {
            androidCanvas.restore();
        }
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        long outlineSize$iv;
        if (this.outlineDirty) {
            boolean outlineIsNeeded = getClip() || getShadowElevation() > 0.0f;
            if (!outlineIsNeeded) {
                this.impl.setOutline(null);
            } else {
                Path tmpPath = this.outlinePath;
                if (tmpPath != null) {
                    android.graphics.Outline androidOutline = updatePathOutline(tmpPath);
                    androidOutline.setAlpha(getAlpha());
                    this.impl.setOutline(androidOutline);
                } else {
                    android.graphics.Outline roundRectOutline = obtainAndroidOutline();
                    long layerSize$iv = IntSizeKt.m6879toSizeozmzZPI(this.size);
                    long rRectTopLeft$iv = this.roundRectOutlineTopLeft;
                    long rRectSize$iv = this.roundRectOutlineSize;
                    if (rRectSize$iv == InlineClassHelperKt.UnspecifiedPackedFloats) {
                        outlineSize$iv = layerSize$iv;
                    } else {
                        outlineSize$iv = rRectSize$iv;
                    }
                    long outlineSize = outlineSize$iv;
                    float $this$fastRoundToInt$iv = Offset.m3945getXimpl(rRectTopLeft$iv);
                    int iRound = Math.round($this$fastRoundToInt$iv);
                    float $this$fastRoundToInt$iv2 = Offset.m3946getYimpl(rRectTopLeft$iv);
                    int iRound2 = Math.round($this$fastRoundToInt$iv2);
                    float $this$fastRoundToInt$iv3 = Offset.m3945getXimpl(rRectTopLeft$iv) + Size.m4014getWidthimpl(outlineSize);
                    int iRound3 = Math.round($this$fastRoundToInt$iv3);
                    float $this$fastRoundToInt$iv4 = Offset.m3946getYimpl(rRectTopLeft$iv) + Size.m4011getHeightimpl(outlineSize);
                    roundRectOutline.setRoundRect(iRound, iRound2, iRound3, Math.round($this$fastRoundToInt$iv4), this.roundRectCornerRadius);
                    roundRectOutline.setAlpha(getAlpha());
                    this.impl.setOutline(roundRectOutline);
                }
            }
        }
        this.outlineDirty = false;
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> block) {
        long outlineSize;
        long layerSize = IntSizeKt.m6879toSizeozmzZPI(this.size);
        long rRectTopLeft = this.roundRectOutlineTopLeft;
        long rRectSize = this.roundRectOutlineSize;
        if (rRectSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            outlineSize = layerSize;
        } else {
            outlineSize = rRectSize;
        }
        return block.invoke(Offset.m3934boximpl(rRectTopLeft), Size.m4002boximpl(outlineSize));
    }

    private final android.graphics.Outline updatePathOutline(Path path) {
        android.graphics.Outline resultOutline = obtainAndroidOutline();
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            if (Build.VERSION.SDK_INT > 30) {
                OutlineVerificationHelper.INSTANCE.setPath(resultOutline, path);
            } else if (path instanceof AndroidPath) {
                resultOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            this.usePathForClip = !resultOutline.canClip();
        } else {
            android.graphics.Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return resultOutline;
    }

    private final android.graphics.Outline obtainAndroidOutline() {
        android.graphics.Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        android.graphics.Outline it = new android.graphics.Outline();
        this.androidOutline = it;
        return it;
    }

    public final void release$ui_graphics_release() {
        if (!this.isReleased) {
            this.isReleased = true;
            discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            if (this.layerManager != null) {
                this.layerManager.release(this);
            } else {
                discardDisplayList$ui_graphics_release();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void discardDisplayList$ui_graphics_release() {
        /*
            r24 = this;
            r0 = r24
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r1 = r0.childDependenciesTracker
            r2 = 0
            androidx.compose.ui.graphics.layer.GraphicsLayer r3 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r1)
            if (r3 == 0) goto L19
            r4 = 0
            r5 = r3
            r6 = 0
            r5.onRemovedFromParentLayer()
            r5 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setDependency$p(r1, r5)
        L19:
            androidx.collection.MutableScatterSet r3 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r1)
            if (r3 == 0) goto La2
            r4 = 0
            r5 = r3
            androidx.collection.ScatterSet r5 = (androidx.collection.ScatterSet) r5
            r6 = 0
            java.lang.Object[] r7 = r5.elements
            r8 = r5
            r9 = 0
            long[] r10 = r8.metadata
            int r11 = r10.length
            int r11 = r11 + (-2)
            r12 = 0
            if (r12 > r11) goto L94
        L32:
            r13 = r10[r12]
            r15 = r13
            r17 = 0
            r18 = r1
            r19 = r2
            r1 = r15
            r15 = r3
            r16 = r4
            long r3 = ~r1
            r20 = 7
            long r3 = r3 << r20
            long r3 = r3 & r1
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r1 = r3 & r20
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L88
            int r1 = r12 - r11
            int r1 = ~r1
            int r1 = r1 >>> 31
            r2 = 8
            int r1 = 8 - r1
            r3 = 0
        L5a:
            if (r3 >= r1) goto L86
            r20 = 255(0xff, double:1.26E-321)
            long r20 = r13 & r20
            r4 = 0
            r22 = 128(0x80, double:6.3E-322)
            int r17 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r17 >= 0) goto L6a
            r17 = 1
            goto L6c
        L6a:
            r17 = 0
        L6c:
            if (r17 == 0) goto L82
            int r4 = r12 << 3
            int r4 = r4 + r3
            r17 = r4
            r20 = 0
            r21 = r7[r17]
            androidx.compose.ui.graphics.layer.GraphicsLayer r21 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r21
            r22 = 0
            r21.onRemovedFromParentLayer()
        L82:
            long r13 = r13 >> r2
            int r3 = r3 + 1
            goto L5a
        L86:
            if (r1 != r2) goto L9c
        L88:
            if (r12 == r11) goto L9b
            int r12 = r12 + 1
            r3 = r15
            r4 = r16
            r1 = r18
            r2 = r19
            goto L32
        L94:
            r18 = r1
            r19 = r2
            r15 = r3
            r16 = r4
        L9b:
        L9c:
            r15.clear()
            goto La6
        La2:
            r18 = r1
            r19 = r2
        La6:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r1 = r0.impl
            r1.discardDisplayList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.discardDisplayList$ui_graphics_release():void");
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        long outlineSize$iv;
        androidx.compose.ui.graphics.Outline tmpOutline = this.internalOutline;
        Path tmpPath = this.outlinePath;
        if (tmpOutline != null) {
            return tmpOutline;
        }
        if (tmpPath != null) {
            Outline.Generic it = new Outline.Generic(tmpPath);
            this.internalOutline = it;
            return it;
        }
        long layerSize$iv = IntSizeKt.m6879toSizeozmzZPI(this.size);
        long rRectTopLeft$iv = this.roundRectOutlineTopLeft;
        long rRectSize$iv = this.roundRectOutlineSize;
        if (rRectSize$iv == InlineClassHelperKt.UnspecifiedPackedFloats) {
            outlineSize$iv = layerSize$iv;
        } else {
            outlineSize$iv = rRectSize$iv;
        }
        long outlineSize = outlineSize$iv;
        float left = Offset.m3945getXimpl(rRectTopLeft$iv);
        float top = Offset.m3946getYimpl(rRectTopLeft$iv);
        float right = left + Size.m4014getWidthimpl(outlineSize);
        float bottom = top + Size.m4011getHeightimpl(outlineSize);
        float cornerRadius = this.roundRectCornerRadius;
        androidx.compose.ui.graphics.Outline it2 = cornerRadius > 0.0f ? new Outline.Rounded(RoundRectKt.m3999RoundRectgG7oq9Y(left, top, right, bottom, CornerRadiusKt.CornerRadius$default(cornerRadius, 0.0f, 2, null))) : new Outline.Rectangle(new Rect(left, top, right, bottom));
        this.internalOutline = it2;
        return it2;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m4022getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m3961getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m4850setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m3942equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m4010equalsimpl0(this.roundRectOutlineSize, size)) {
            if ((this.roundRectCornerRadius == cornerRadius) && this.outlinePath == null) {
                return;
            }
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutline();
    }

    /* renamed from: setRectOutline-tz77jQw$default, reason: not valid java name */
    public static /* synthetic */ void m4834setRectOutlinetz77jQw$default(GraphicsLayer graphicsLayer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m3961getZeroF1C5BW0();
        }
        if ((i & 2) != 0) {
            j2 = Size.INSTANCE.m4022getUnspecifiedNHjbRc();
        }
        graphicsLayer.m4849setRectOutlinetz77jQw(j, j2);
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m4849setRectOutlinetz77jQw(long topLeft, long size) {
        m4850setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4837getAmbientShadowColor0d7_KjU() {
        return this.impl.getAmbientShadowColor();
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m4845setAmbientShadowColor8_81llA(long value) {
        if (!Color.m4188equalsimpl0(value, this.impl.getAmbientShadowColor())) {
            this.impl.mo4858setAmbientShadowColor8_81llA(value);
        }
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4842getSpotShadowColor0d7_KjU() {
        return this.impl.getSpotShadowColor();
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m4851setSpotShadowColor8_81llA(long value) {
        if (!Color.m4188equalsimpl0(value, this.impl.getSpotShadowColor())) {
            this.impl.mo4863setSpotShadowColor8_81llA(value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object toImageBitmap(kotlin.coroutines.Continuation<? super androidx.compose.ui.graphics.ImageBitmap> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L31;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L2c:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r6
            goto L41
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r3 = androidx.compose.ui.graphics.layer.GraphicsLayer.SnapshotImpl
            r4 = 1
            r0.label = r4
            java.lang.Object r2 = r3.toBitmap(r2, r0)
            if (r2 != r1) goto L41
            return r1
        L41:
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            androidx.compose.ui.graphics.ImageBitmap r1 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.asImageBitmap(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.toImageBitmap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        LayerSnapshotV21 layerSnapshotV21;
        if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotV21 = LayerSnapshotV28.INSTANCE;
        } else if (Build.VERSION.SDK_INT >= 22 && SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotV21 = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotV21 = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotV21;
    }
}
