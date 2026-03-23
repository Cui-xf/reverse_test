package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BackdropScaffold.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u0010\r\u001aò\u0001\u0010\u000e\u001a\u00020\u00062\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aH\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u00162\b\b\u0002\u00101\u001a\u00020\u0017H\u0007\u001a[\u00102\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050\u00162\u001d\u00106\u001a\u0019\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000607¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u00108\u001a\u001c\u00109\u001a\u00020:2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0000\u001a0\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u001f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010B\u001a\u00020\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aE\u0010E\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\b2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u00162\b\b\u0002\u00101\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010G\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020/X\u008a\u0084\u0002"}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "PositionalThreshold", "VelocityThreshold", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "BackdropScaffold-0hNv9B8", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;Lkotlin/jvm/functions/Function3;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLandroidx/compose/runtime/Composer;III)V", "BackdropScaffoldState", "initialValue", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "snackbarHostState", "BackdropStack", "backLayer", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "confirmStateChange", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m6693constructorimpl(20);
    private static final float VelocityThreshold = Dp.m6693constructorimpl(125);
    private static final float PositionalThreshold = Dp.m6693constructorimpl(56);

    public static /* synthetic */ BackdropScaffoldState BackdropScaffoldState$default(BackdropValue backdropValue, Density density, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue it) {
                    return true;
                }
            };
        }
        if ((i & 16) != 0) {
            snackbarHostState = new SnackbarHostState();
        }
        return BackdropScaffoldState(backdropValue, density, animationSpec, function1, snackbarHostState);
    }

    public static final BackdropScaffoldState BackdropScaffoldState(BackdropValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        BackdropScaffoldState it = new BackdropScaffoldState(initialValue, animationSpec, function1, snackbarHostState);
        it.setDensity$material_release(density);
        return it;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[PHI: r9
      0x00b8: PHI (r9v3 androidx.compose.material.BackdropValue) = (r9v1 androidx.compose.material.BackdropValue), (r9v4 androidx.compose.material.BackdropValue) binds: [B:28:0x00b6, B:24:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.material.BackdropScaffoldState rememberBackdropScaffoldState(androidx.compose.material.BackdropValue r16, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r17, kotlin.jvm.functions.Function1<? super androidx.compose.material.BackdropValue, java.lang.Boolean> r18, androidx.compose.material.SnackbarHostState r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState(androidx.compose.material.BackdropValue, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, int, int):androidx.compose.material.BackdropScaffoldState");
    }

    /* renamed from: BackdropScaffold-0hNv9B8, reason: not valid java name */
    public static final void m1431BackdropScaffold0hNv9B8(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Modifier modifier, BackdropScaffoldState scaffoldState, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        BackdropScaffoldState backdropScaffoldState;
        Function3 function32;
        boolean z;
        float f;
        float f2;
        int i2;
        int i3;
        long j;
        Modifier modifier2;
        final BackdropScaffoldState scaffoldState2;
        float peekHeight2;
        float headerHeight2;
        final boolean persistentAppBar2;
        long backLayerBackgroundColor2;
        int $dirty1;
        long backLayerContentColor2;
        long backLayerBackgroundColor3;
        Shape frontLayerShape2;
        float frontLayerElevation2;
        float frontLayerElevation3;
        Shape frontLayerShape3;
        long frontLayerBackgroundColor2;
        final long frontLayerContentColor2;
        final Modifier modifier3;
        final float frontLayerElevation4;
        final long frontLayerScrimColor2;
        final Function3 snackbarHost;
        int $dirty12;
        long backLayerBackgroundColor4;
        final Shape frontLayerShape4;
        final boolean gesturesEnabled2;
        long backLayerContentColor3;
        final boolean stickyFrontLayer2;
        long frontLayerBackgroundColor3;
        long backLayerBackgroundColor5;
        Object value$iv;
        Composer $composer2;
        final long backLayerContentColor4;
        final boolean persistentAppBar3;
        final Modifier modifier4;
        final boolean stickyFrontLayer3;
        final boolean gesturesEnabled3;
        final Shape frontLayerShape5;
        final long frontLayerBackgroundColor4;
        final long frontLayerContentColor3;
        final float frontLayerElevation5;
        final float headerHeight3;
        final float peekHeight3;
        final Function3 snackbarHost2;
        final long backLayerBackgroundColor6;
        final BackdropScaffoldState scaffoldState3;
        final long frontLayerScrimColor3;
        Composer $composer3 = $composer.startRestartGroup(113877443);
        ComposerKt.sourceInformation($composer3, "C(BackdropScaffold)P(!1,2,5,12,15,16,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)371@15931L40,378@16340L6,379@16391L41,380@16488L15,382@16634L6,383@16686L42,384@16789L20,387@16929L7,388@16952L47,388@16941L58,*392@17042L7,393@17116L7,395@17182L315,408@17568L100,418@17848L3899,415@17746L4001:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 256 : 128;
        }
        int i4 = i & 8;
        int i5 = 1024;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i6 = 8192;
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                backdropScaffoldState = scaffoldState;
                int i7 = $composer3.changed(backdropScaffoldState) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                backdropScaffoldState = scaffoldState;
            }
            $dirty |= i7;
        } else {
            backdropScaffoldState = scaffoldState;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function32 = function3;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            function32 = function3;
            $dirty |= $composer3.changedInstance(function32) ? 131072 : 65536;
        } else {
            function32 = function3;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
            z = gesturesEnabled;
        } else if (($changed & 1572864) == 0) {
            z = gesturesEnabled;
            $dirty |= $composer3.changed(z) ? 1048576 : 524288;
        } else {
            z = gesturesEnabled;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                f = peekHeight;
                int i10 = $composer3.changed(f) ? 8388608 : 4194304;
                $dirty |= i10;
            } else {
                f = peekHeight;
            }
            $dirty |= i10;
        } else {
            f = peekHeight;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0) {
                f2 = headerHeight;
                int i11 = $composer3.changed(f2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty |= i11;
            } else {
                f2 = headerHeight;
            }
            $dirty |= i11;
        } else {
            f2 = headerHeight;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
            i2 = i12;
        } else if (($changed & 805306368) == 0) {
            i2 = i12;
            $dirty |= $composer3.changed(persistentAppBar) ? 536870912 : 268435456;
        } else {
            i2 = i12;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty13 |= 6;
            i3 = i13;
        } else if (($changed1 & 6) == 0) {
            i3 = i13;
            $dirty13 |= $composer3.changed(stickyFrontLayer) ? 4 : 2;
        } else {
            i3 = i13;
        }
        if (($changed1 & 48) == 0) {
            $dirty13 |= ((i & 2048) == 0 && $composer3.changed(backLayerBackgroundColor)) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty13 |= ((i & 4096) == 0 && $composer3.changed(backLayerContentColor)) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0 && $composer3.changed(frontLayerShape)) {
                i5 = 2048;
            }
            $dirty13 |= i5;
        }
        if (($changed1 & 24576) == 0) {
            if ((i & 16384) == 0 && $composer3.changed(frontLayerElevation)) {
                i6 = 16384;
            }
            $dirty13 |= i6;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty13 |= ((i & 32768) == 0 && $composer3.changed(frontLayerBackgroundColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty13 |= ((i & 65536) == 0 && $composer3.changed(frontLayerContentColor)) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            if ((i & 131072) == 0) {
                j = frontLayerScrimColor;
                int i14 = $composer3.changed(j) ? 8388608 : 4194304;
                $dirty13 |= i14;
            } else {
                j = frontLayerScrimColor;
            }
            $dirty13 |= i14;
        } else {
            j = frontLayerScrimColor;
        }
        int $dirty14 = $dirty13;
        if ((306783379 & $dirty) == 306783378 && ($dirty14 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            frontLayerElevation5 = frontLayerElevation;
            frontLayerBackgroundColor4 = frontLayerBackgroundColor;
            frontLayerContentColor3 = frontLayerContentColor;
            frontLayerScrimColor3 = j;
            scaffoldState3 = backdropScaffoldState;
            $composer2 = $composer3;
            peekHeight3 = f;
            headerHeight3 = f2;
            gesturesEnabled3 = z;
            snackbarHost2 = function32;
            persistentAppBar3 = persistentAppBar;
            stickyFrontLayer3 = stickyFrontLayer;
            backLayerBackgroundColor6 = backLayerBackgroundColor;
            backLayerContentColor4 = backLayerContentColor;
            frontLayerShape5 = frontLayerShape;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 16) != 0) {
                    modifier2 = modifier5;
                    scaffoldState2 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, $composer3, 6, 14);
                    $dirty &= -57345;
                } else {
                    modifier2 = modifier5;
                    scaffoldState2 = scaffoldState;
                }
                Function3 snackbarHost3 = i8 != 0 ? ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1520getLambda1$material_release() : function32;
                boolean gesturesEnabled4 = i9 != 0 ? true : z;
                if ((i & 128) != 0) {
                    peekHeight2 = BackdropScaffoldDefaults.INSTANCE.m1430getPeekHeightD9Ej5fM();
                    $dirty &= -29360129;
                } else {
                    peekHeight2 = peekHeight;
                }
                if ((i & 256) != 0) {
                    headerHeight2 = BackdropScaffoldDefaults.INSTANCE.m1429getHeaderHeightD9Ej5fM();
                    $dirty &= -234881025;
                } else {
                    headerHeight2 = headerHeight;
                }
                persistentAppBar2 = i2 != 0 ? true : persistentAppBar;
                boolean stickyFrontLayer4 = i3 != 0 ? true : stickyFrontLayer;
                if ((i & 2048) != 0) {
                    backLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getPrimary0d7_KjU();
                    $dirty1 = $dirty14 & (-113);
                } else {
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                    $dirty1 = $dirty14;
                }
                if ((i & 4096) != 0) {
                    backLayerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(backLayerBackgroundColor2, $composer3, ($dirty1 >> 3) & 14);
                    $dirty1 &= -897;
                } else {
                    backLayerContentColor2 = backLayerContentColor;
                }
                if ((i & 8192) != 0) {
                    backLayerBackgroundColor3 = backLayerBackgroundColor2;
                    frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape($composer3, 0);
                    $dirty1 &= -7169;
                } else {
                    backLayerBackgroundColor3 = backLayerBackgroundColor2;
                    frontLayerShape2 = frontLayerShape;
                }
                if ((i & 16384) != 0) {
                    frontLayerElevation2 = BackdropScaffoldDefaults.INSTANCE.m1428getFrontLayerElevationD9Ej5fM();
                    $dirty1 &= -57345;
                } else {
                    frontLayerElevation2 = frontLayerElevation;
                }
                if ((32768 & i) != 0) {
                    frontLayerElevation3 = frontLayerElevation2;
                    $dirty1 &= -458753;
                    frontLayerShape3 = frontLayerShape2;
                    frontLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                } else {
                    frontLayerElevation3 = frontLayerElevation2;
                    frontLayerShape3 = frontLayerShape2;
                    frontLayerBackgroundColor2 = frontLayerBackgroundColor;
                }
                if ((i & 65536) != 0) {
                    frontLayerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(frontLayerBackgroundColor2, $composer3, ($dirty1 >> 15) & 14);
                    $dirty1 &= -3670017;
                } else {
                    frontLayerContentColor2 = frontLayerContentColor;
                }
                if ((i & 131072) != 0) {
                    long frontLayerBackgroundColor5 = frontLayerBackgroundColor2;
                    modifier3 = modifier2;
                    $dirty12 = $dirty1 & (-29360129);
                    snackbarHost = snackbarHost3;
                    backLayerBackgroundColor4 = backLayerBackgroundColor3;
                    frontLayerScrimColor2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor($composer3, 0);
                    frontLayerShape4 = frontLayerShape3;
                    frontLayerElevation4 = frontLayerElevation3;
                    gesturesEnabled2 = gesturesEnabled4;
                    backLayerContentColor3 = backLayerContentColor2;
                    stickyFrontLayer2 = stickyFrontLayer4;
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor5;
                } else {
                    long frontLayerBackgroundColor6 = frontLayerBackgroundColor2;
                    modifier3 = modifier2;
                    frontLayerElevation4 = frontLayerElevation3;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    snackbarHost = snackbarHost3;
                    $dirty12 = $dirty1;
                    backLayerBackgroundColor4 = backLayerBackgroundColor3;
                    frontLayerShape4 = frontLayerShape3;
                    gesturesEnabled2 = gesturesEnabled4;
                    backLayerContentColor3 = backLayerContentColor2;
                    stickyFrontLayer2 = stickyFrontLayer4;
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor6;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 2048) != 0) {
                    $dirty14 &= -113;
                }
                int $dirty15 = $dirty14;
                if ((i & 4096) != 0) {
                    $dirty15 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty15 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty15 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty15 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty15 &= -3670017;
                }
                if ((i & 131072) != 0) {
                    $dirty15 &= -29360129;
                }
                modifier3 = modifier;
                stickyFrontLayer2 = stickyFrontLayer;
                frontLayerShape4 = frontLayerShape;
                frontLayerElevation4 = frontLayerElevation;
                frontLayerContentColor2 = frontLayerContentColor;
                $dirty12 = $dirty15;
                frontLayerScrimColor2 = j;
                scaffoldState2 = backdropScaffoldState;
                peekHeight2 = f;
                headerHeight2 = f2;
                gesturesEnabled2 = z;
                snackbarHost = function32;
                persistentAppBar2 = persistentAppBar;
                backLayerBackgroundColor4 = backLayerBackgroundColor;
                backLayerContentColor3 = backLayerContentColor;
                frontLayerBackgroundColor3 = frontLayerBackgroundColor;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                backLayerBackgroundColor5 = backLayerBackgroundColor4;
                ComposerKt.traceEventStart(113877443, $dirty, $dirty12, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:385)");
            } else {
                backLayerBackgroundColor5 = backLayerBackgroundColor4;
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            int $dirty16 = $dirty12;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer3, 1348845825, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = ((((57344 & $dirty) ^ 24576) > 16384 && $composer3.changed(scaffoldState2)) || ($dirty & 24576) == 16384) | $composer3.changed(density);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        scaffoldState2.setDensity$material_release(density);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.SideEffect((Function0) value$iv2, $composer3, 0);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackdropScaffold_0hNv9B8_u24lambda_u244 = (Density) objConsume2;
            final float peekHeightPx = $this$BackdropScaffold_0hNv9B8_u24lambda_u244.mo367toPx0680j_4(peekHeight2);
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackdropScaffold_0hNv9B8_u24lambda_u245 = (Density) objConsume3;
            final float headerHeightPx = $this$BackdropScaffold_0hNv9B8_u24lambda_u245.mo367toPx0680j_4(headerHeight2);
            final Function2 backLayer = ComposableLambdaKt.rememberComposableLambda(461235665, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461235665, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:396)");
                        }
                        if (!persistentAppBar2) {
                            $composer4.startReplaceGroup(1665392524);
                            ComposerKt.sourceInformation($composer4, "402@17340L141");
                            BackdropScaffoldKt.BackLayerTransition(scaffoldState2.getAnchoredDraggableState$material_release().getTargetValue(), function2, function22, $composer4, 0);
                            $composer4.endReplaceGroup();
                        } else {
                            $composer4.startReplaceGroup(1665279591);
                            ComposerKt.sourceInformation($composer4, "397@17228L82");
                            Function2<Composer, Integer, Unit> function24 = function2;
                            Function2<Composer, Integer, Unit> function25 = function22;
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv2;
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv2;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                            }
                            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i15 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i16 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1362616, "C398@17253L8,399@17278L18:BackdropScaffold.kt#jmzs0o");
                            function24.invoke($composer4, 0);
                            function25.invoke($composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            ComposerKt.sourceInformationMarkerStart($composer3, 1348865590, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(headerHeightPx);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                        return Constraints.m6624boximpl(m1438invokeZezNO4M(constraints.getValue()));
                    }

                    /* renamed from: invoke-ZezNO4M, reason: not valid java name */
                    public final long m1438invokeZezNO4M(long it) {
                        return ConstraintsKt.m6656offsetNN6EwU$default(Constraints.m6626copyZbe2FdA(it, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(it) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(it) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(it) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(it) : 0), 0, -MathKt.roundToInt(headerHeightPx), 1, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function1 calculateBackLayerConstraints = (Function1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final AnchoredDraggableState state = scaffoldState2.getAnchoredDraggableState$material_release();
            final BackdropScaffoldState scaffoldState4 = scaffoldState2;
            final float peekHeight4 = peekHeight2;
            final float headerHeight4 = headerHeight2;
            final long frontLayerBackgroundColor7 = frontLayerBackgroundColor3;
            long backLayerContentColor5 = backLayerContentColor3;
            SurfaceKt.m1676SurfaceFjzlyU(null, null, backLayerBackgroundColor5, backLayerContentColor5, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1961515015, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C419@17870L24,424@18029L3712,420@17903L3838:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1961515015, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:419)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer4, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function24 = backLayer;
                        Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints;
                        final float f3 = headerHeightPx;
                        final boolean z2 = stickyFrontLayer2;
                        final boolean z3 = gesturesEnabled2;
                        final BackdropScaffoldState backdropScaffoldState2 = scaffoldState4;
                        final AnchoredDraggableState<BackdropValue> anchoredDraggableState = state;
                        final Shape shape = frontLayerShape4;
                        final long j2 = frontLayerBackgroundColor7;
                        final long j3 = frontLayerContentColor2;
                        final float f4 = frontLayerElevation4;
                        final float f5 = headerHeight4;
                        final float f6 = peekHeightPx;
                        final float f7 = peekHeight4;
                        final Function2<Composer, Integer, Unit> function25 = function23;
                        final long j4 = frontLayerScrimColor2;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = snackbarHost;
                        BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function24, function1, ComposableLambdaKt.rememberComposableLambda(516504859, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f8, Composer composer, Integer num) {
                                m1436invokejYbf7pk(constraints.getValue(), f8.floatValue(), composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:47:0x016d  */
                            /* JADX WARN: Removed duplicated region for block: B:65:0x02ae  */
                            /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
                            /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final void m1436invokejYbf7pk(long r34, float r36, androidx.compose.runtime.Composer r37, int r38) {
                                /*
                                    Method dump skipped, instructions count: 690
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2.AnonymousClass1.m1436invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                            }
                        }, $composer4, 54), $composer4, 3120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, (($dirty16 << 3) & 896) | 1572864 | (($dirty16 << 3) & 7168), 51);
            long backLayerBackgroundColor7 = backLayerBackgroundColor5;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backLayerContentColor4 = backLayerContentColor5;
            persistentAppBar3 = persistentAppBar2;
            modifier4 = modifier3;
            stickyFrontLayer3 = stickyFrontLayer2;
            gesturesEnabled3 = gesturesEnabled2;
            frontLayerShape5 = frontLayerShape4;
            frontLayerBackgroundColor4 = frontLayerBackgroundColor7;
            frontLayerContentColor3 = frontLayerContentColor2;
            frontLayerElevation5 = frontLayerElevation4;
            headerHeight3 = headerHeight4;
            peekHeight3 = peekHeight4;
            snackbarHost2 = snackbarHost;
            backLayerBackgroundColor6 = backLayerBackgroundColor7;
            scaffoldState3 = scaffoldState4;
            frontLayerScrimColor3 = frontLayerScrimColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i15) {
                    BackdropScaffoldKt.m1431BackdropScaffold0hNv9B8(function2, function22, function23, modifier4, scaffoldState3, snackbarHost2, gesturesEnabled3, peekHeight3, headerHeight3, persistentAppBar3, stickyFrontLayer3, backLayerBackgroundColor6, backLayerContentColor4, frontLayerShape5, frontLayerElevation5, frontLayerBackgroundColor4, frontLayerContentColor3, frontLayerScrimColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1432Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color):BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, $dirty, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:517)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                $composer2.startReplaceGroup(478578989);
                ComposerKt.sourceInformation($composer2, "519@21902L121,532@22312L62,528@22203L171");
                int $dirty2 = $dirty;
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1065353216 : 0, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                if (visible) {
                    $composer2.startReplaceGroup(478752713);
                    ComposerKt.sourceInformation($composer2, "524@22109L37");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1262370917, "CC(remember):BackdropScaffold.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 112) == 32;
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 value$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(478845186);
                    $composer2.endReplaceGroup();
                    dismissModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, 1262377438, "CC(remember):BackdropScaffold.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(alpha$delegate) | (($dirty2 & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$Canvas) {
                            DrawScope.CC.m4747drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, BackdropScaffoldKt.Scrim_3J_VO9M$lambda$7(alpha$delegate), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(479060450);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    BackdropScaffoldKt.m1432Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$7(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue target, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Object value$iv;
        Object value$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)551@22995L112,*554@23157L7,556@23203L1485:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(target) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:548)");
            }
            final State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(target == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer3, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackLayerTransition_u24lambda_u2411 = (Density) objConsume;
            final float animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411.mo367toPx0680j_4(AnimationSlideOffset);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            $composer2 = $composer3;
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1148278766, "C559@23267L351,566@23650L218,557@23217L694,577@24032L353,584@24417L221,574@23920L762:BackdropScaffold.kt#jmzs0o");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -452682761, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(animationProgress$delegate);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1434invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1434invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        float $this$fastCoerceIn$iv = BackdropScaffoldKt.BackLayerTransition$lambda$10(animationProgress$delegate) - 1.0f;
                        final float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        final Placeable placeable = measurable.mo5535measureBRTryo0(constraints);
                        return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                $this$layout2.place(placeable, 0, 0, $this$fastCoerceAtLeast$iv$iv);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) value$iv3);
            ComposerKt.sourceInformationMarkerStart($composer2, -452670638, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(animationProgress$delegate) | $composer2.changed(animationSlideOffset);
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                        float $this$fastCoerceIn$iv = BackdropScaffoldKt.BackLayerTransition$lambda$10(animationProgress$delegate) - 1.0f;
                        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        $this$graphicsLayer.setAlpha($this$fastCoerceAtLeast$iv$iv);
                        $this$graphicsLayer.setTranslationY((1.0f - $this$fastCoerceAtLeast$iv$iv) * animationSlideOffset);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = GraphicsLayerModifierKt.graphicsLayer(modifierLayout, (Function1) value$iv4);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 799556868, "C572@23893L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -452658279, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(animationProgress$delegate);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1435invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1435invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        float $this$fastCoerceIn$iv = 1.0f - BackdropScaffoldKt.BackLayerTransition$lambda$10(animationProgress$delegate);
                        final float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        final Placeable placeable = measurable.mo5535measureBRTryo0(constraints);
                        return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                $this$layout2.place(placeable, 0, 0, $this$fastCoerceAtLeast$iv$iv);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierLayout2 = LayoutModifierKt.layout(companion2, (Function3) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, -452646091, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(animationProgress$delegate) | $composer2.changed(animationSlideOffset);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                        float $this$fastCoerceIn$iv = 1.0f - BackdropScaffoldKt.BackLayerTransition$lambda$10(animationProgress$delegate);
                        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        $this$graphicsLayer.setAlpha($this$fastCoerceAtLeast$iv$iv);
                        $this$graphicsLayer.setTranslationY((1.0f - $this$fastCoerceAtLeast$iv$iv) * animationSlideOffset);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv3 = GraphicsLayerModifierKt.graphicsLayer(modifierLayout2, (Function1) value$iv2);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 800320739, "C590@24663L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke($composer2, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    BackdropScaffoldKt.BackLayerTransition(target, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BackLayerTransition$lambda$10(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)602@24951L890,602@24924L917:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:601)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1431305978, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 896) == 256) | (($dirty & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1439invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1439invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first((List) $this$SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo5535measureBRTryo0(function1.invoke(Constraints.m6624boximpl(constraints)).getValue());
                        final float backLayerHeight = backLayerPlaceable.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C611@25289L40:BackdropScaffold.kt#jmzs0o");
                                if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, $changed2, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:611)");
                                }
                                function42.invoke(Constraints.m6624boximpl(constraints), Float.valueOf(backLayerHeight), $composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int size = $this$fastMap$iv.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            target$iv.add(((Measurable) item$iv$iv).mo5535measureBRTryo0(constraints));
                        }
                        final List placeables = target$iv;
                        int maxWidth = Math.max(Constraints.m6638getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
                        int maxHeight = Math.max(Constraints.m6637getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
                        int size2 = placeables.size();
                        int maxWidth2 = maxWidth;
                        int maxHeight2 = maxHeight;
                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                            Object item$iv = placeables.get(index$iv);
                            Placeable it = (Placeable) item$iv;
                            maxWidth2 = Math.max(maxWidth2, it.getWidth());
                            maxHeight2 = Math.max(maxHeight2, it.getHeight());
                        }
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, maxWidth2, maxHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Placeable.PlacementScope.placeRelative$default($this$layout, backLayerPlaceable, 0, 0, 0.0f, 4, null);
                                List $this$fastForEach$iv = placeables;
                                int size3 = $this$fastForEach$iv.size();
                                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                    Placeable it2 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it2, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* compiled from: BackdropScaffold.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03871 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C03871(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo479onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo477onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo478onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1
                r0.<init>(r6, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                switch(r2) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2c:
                long r7 = r0.J$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L61
            L32:
                kotlin.ResultKt.throwOnFailure(r9)
                r2 = r6
                float r3 = r2.velocityToFloat(r7)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r4 = r4.requireOffset()
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 >= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
                androidx.compose.material.DraggableAnchors r5 = r5.getAnchors()
                float r5 = r5.minAnchor()
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 <= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                r0.J$0 = r7
                r5 = 1
                r0.label = r5
                java.lang.Object r2 = r4.settle(r3, r0)
                if (r2 != r1) goto L61
                return r1
            L61:
                goto L68
            L62:
                androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r7 = r7.m6945getZero9UxMQ8M()
            L68:
                androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.C03871.mo478onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo476onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r4 = this;
                boolean r5 = r9 instanceof androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1
                r5.<init>(r4, r9)
            L19:
                java.lang.Object r6 = r5.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                switch(r0) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2c:
                long r7 = r5.J$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                r0 = r4
                androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
                float r2 = r0.velocityToFloat(r7)
                r5.J$0 = r7
                r3 = 1
                r5.label = r3
                java.lang.Object r0 = r1.settle(r2, r5)
                if (r0 != r9) goto L48
                return r9
            L48:
                androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.C03871.mo476onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m6934getXimpl($this$toFloat) : Velocity.m6935getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m3945getXimpl($this$toFloat) : Offset.m3946getYimpl($this$toFloat);
        }
    }

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C03871(anchoredDraggableState, orientation);
    }
}
