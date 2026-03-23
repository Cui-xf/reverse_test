package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aJ\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\"\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0000\u001a\u0014\u0010&\u001a\u00020$*\u00020'2\u0006\u0010(\u001a\u00020$H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)²\u0006\u0015\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheet_androidKt {

    /* compiled from: ModalBottomSheet.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use constructor with contentWindowInsets parameter.", replaceWith = @ReplaceWith(expression = "ModalBottomSheet(onDismissRequest,modifier,sheetState,sheetMaxWidth,shape,containerColor,contentColor,tonalElevation,scrimColor,dragHandle,{ windowInsets },properties,content,)", imports = {}))
    /* renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    public static final /* synthetic */ void m2266ModalBottomSheetdYc4hso(final Function0 onDismissRequest, Modifier modifier, SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, long scrimColor, Function2 dragHandle, WindowInsets windowInsets, ModalBottomSheetProperties properties, final Function3 content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        SheetState sheetState2;
        float f;
        Shape shape2;
        long j;
        int $dirty;
        int $dirty1;
        int i2;
        int $dirty12;
        int i3;
        Function3 function3;
        int i4;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        long scrimColor2;
        float sheetMaxWidth2;
        WindowInsets windowInsets2;
        float sheetMaxWidth3;
        ModalBottomSheetProperties properties2;
        final WindowInsets windowInsets3;
        int $dirty2;
        float tonalElevation2;
        int $dirty13;
        Shape shape4;
        SheetState sheetState3;
        long scrimColor3;
        Function2 dragHandle2;
        Composer $composer2;
        final Modifier modifier3;
        final SheetState sheetState4;
        final float sheetMaxWidth4;
        final Shape shape5;
        final long containerColor3;
        final long contentColor3;
        final float tonalElevation3;
        final long contentColor4;
        final Function2 dragHandle3;
        final ModalBottomSheetProperties properties3;
        final WindowInsets windowInsets4;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(944867294);
        ComposerKt.sourceInformation($composer3, "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)235@10240L31,237@10371L13,238@10434L14,239@10476L31,241@10584L10,243@10731L12,247@10884L485:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetState2 = sheetState;
                int i6 = $composer3.changed(sheetState2) ? 256 : 128;
                $dirty4 |= i6;
            } else {
                sheetState2 = sheetState;
            }
            $dirty4 |= i6;
        } else {
            sheetState2 = sheetState;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            f = sheetMaxWidth;
        } else if (($changed & 3072) == 0) {
            f = sheetMaxWidth;
            $dirty4 |= $composer3.changed(f) ? 2048 : 1024;
        } else {
            f = sheetMaxWidth;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i8 = $composer3.changed(shape2) ? 16384 : 8192;
                $dirty4 |= i8;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i8;
        } else {
            shape2 = shape;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                j = containerColor;
                int i9 = $composer3.changed(j) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                j = containerColor;
            }
            $dirty4 |= i9;
        } else {
            j = containerColor;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
                int i10 = $composer3.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i10;
            } else {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
            }
            $dirty = $dirty3 | i10;
        } else {
            $dirty = $dirty4;
            $dirty1 = $changed1;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(tonalElevation) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(scrimColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
            i2 = i12;
        } else if (($changed & 805306368) == 0) {
            i2 = i12;
            $dirty |= $composer3.changedInstance(dragHandle) ? 536870912 : 268435456;
        } else {
            i2 = i12;
        }
        int $dirty5 = $dirty;
        if (($changed1 & 6) == 0) {
            $dirty12 = $dirty1 | (((i & 1024) == 0 && $composer3.changed(windowInsets)) ? 4 : 2);
        } else {
            $dirty12 = $dirty1;
        }
        int i13 = i & 2048;
        if (i13 != 0) {
            $dirty12 |= 48;
            i3 = i13;
        } else if (($changed1 & 48) == 0) {
            i3 = i13;
            $dirty12 |= $composer3.changed(properties) ? 32 : 16;
        } else {
            i3 = i13;
        }
        int $dirty14 = $dirty12;
        if ((i & 4096) != 0) {
            $dirty14 |= 384;
            function3 = content;
        } else if (($changed1 & 384) == 0) {
            function3 = content;
            $dirty14 |= $composer3.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = content;
        }
        if ((306783379 & $dirty5) == 306783378 && ($dirty14 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            tonalElevation3 = tonalElevation;
            properties3 = properties;
            $composer2 = $composer3;
            sheetMaxWidth4 = f;
            shape5 = shape2;
            containerColor3 = j;
            modifier3 = modifier2;
            sheetState4 = sheetState2;
            contentColor3 = contentColor;
            contentColor4 = scrimColor;
            dragHandle3 = dragHandle;
            windowInsets4 = windowInsets;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    i4 = -3670017;
                    $dirty5 &= -897;
                    sheetState2 = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, $composer3, 0, 3);
                } else {
                    i4 = -3670017;
                }
                float sheetMaxWidth5 = i7 != 0 ? BottomSheetDefaults.INSTANCE.m1811getSheetMaxWidthD9Ej5fM() : f;
                if ((i & 16) != 0) {
                    shape3 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer3, 6);
                    $dirty5 &= -57345;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty5 &= -458753;
                } else {
                    containerColor2 = j;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorSchemeKt.m1948contentColorForek8zF_U(containerColor2, $composer3, ($dirty5 >> 15) & 14);
                    $dirty5 &= i4;
                } else {
                    contentColor2 = contentColor;
                }
                float tonalElevation4 = i11 != 0 ? Dp.m6693constructorimpl(0) : tonalElevation;
                if ((i & 256) != 0) {
                    scrimColor2 = BottomSheetDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty5 &= -234881025;
                } else {
                    scrimColor2 = scrimColor;
                }
                Function2 dragHandle4 = i2 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1990getLambda1$material3_release() : dragHandle;
                int $dirty6 = $dirty5;
                if ((i & 1024) != 0) {
                    sheetMaxWidth2 = sheetMaxWidth5;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty14 &= -15;
                } else {
                    sheetMaxWidth2 = sheetMaxWidth5;
                    windowInsets2 = windowInsets;
                }
                if (i3 != 0) {
                    sheetMaxWidth3 = sheetMaxWidth2;
                    properties2 = ModalBottomSheetDefaults.INSTANCE.getProperties();
                    tonalElevation2 = tonalElevation4;
                    windowInsets3 = windowInsets2;
                    $dirty2 = $dirty14;
                    shape4 = shape3;
                    sheetState3 = sheetState2;
                    scrimColor3 = scrimColor2;
                    dragHandle2 = dragHandle4;
                    $dirty13 = $dirty6;
                } else {
                    sheetMaxWidth3 = sheetMaxWidth2;
                    properties2 = properties;
                    windowInsets3 = windowInsets2;
                    $dirty2 = $dirty14;
                    tonalElevation2 = tonalElevation4;
                    $dirty13 = $dirty6;
                    shape4 = shape3;
                    sheetState3 = sheetState2;
                    scrimColor3 = scrimColor2;
                    dragHandle2 = dragHandle4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty5 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty5 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 256) != 0) {
                    $dirty5 &= -234881025;
                }
                if ((i & 1024) != 0) {
                    int i14 = $dirty14 & (-15);
                    tonalElevation2 = tonalElevation;
                    dragHandle2 = dragHandle;
                    properties2 = properties;
                    $dirty13 = $dirty5;
                    $dirty2 = i14;
                    sheetMaxWidth3 = f;
                    shape4 = shape2;
                    containerColor2 = j;
                    sheetState3 = sheetState2;
                    contentColor2 = contentColor;
                    scrimColor3 = scrimColor;
                    windowInsets3 = windowInsets;
                } else {
                    int i15 = $dirty14;
                    $dirty13 = $dirty5;
                    $dirty2 = i15;
                    tonalElevation2 = tonalElevation;
                    dragHandle2 = dragHandle;
                    windowInsets3 = windowInsets;
                    properties2 = properties;
                    sheetMaxWidth3 = f;
                    shape4 = shape2;
                    containerColor2 = j;
                    sheetState3 = sheetState2;
                    contentColor2 = contentColor;
                    scrimColor3 = scrimColor;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $composer2 = $composer3;
                ComposerKt.traceEventStart(944867294, $dirty13, $dirty2, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:247)");
            } else {
                $composer2 = $composer3;
            }
            Function3 function32 = function3;
            Modifier modifier4 = modifier2;
            float tonalElevation5 = tonalElevation2;
            ModalBottomSheetKt.m2260ModalBottomSheetdYc4hso(onDismissRequest, modifier4, sheetState3, sheetMaxWidth3, shape4, containerColor2, contentColor2, tonalElevation5, scrimColor3, dragHandle2, new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer, Integer num) {
                    return invoke(composer, num.intValue());
                }

                public final WindowInsets invoke(Composer $composer4, int $changed2) {
                    $composer4.startReplaceGroup(-2061903609);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2061903609, $changed2, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:258)");
                    }
                    WindowInsets windowInsets5 = windowInsets3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer4.endReplaceGroup();
                    return windowInsets5;
                }
            }, properties2, function32, $composer2, ($dirty13 & 14) | ($dirty13 & 112) | ($dirty13 & 896) | ($dirty13 & 7168) | (57344 & $dirty13) | (458752 & $dirty13) | (3670016 & $dirty13) | (29360128 & $dirty13) | (234881024 & $dirty13) | (1879048192 & $dirty13), ($dirty2 & 112) | ($dirty2 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            sheetState4 = sheetState3;
            sheetMaxWidth4 = sheetMaxWidth3;
            shape5 = shape4;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            tonalElevation3 = tonalElevation5;
            contentColor4 = scrimColor3;
            dragHandle3 = dragHandle2;
            properties3 = properties2;
            windowInsets4 = windowInsets3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2
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

                public final void invoke(Composer composer, int i16) {
                    ModalBottomSheet_androidKt.m2266ModalBottomSheetdYc4hso(onDismissRequest, modifier3, sheetState4, sheetMaxWidth4, shape5, containerColor3, contentColor3, tonalElevation3, contentColor4, dragHandle3, windowInsets4, properties3, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void ModalBottomSheetDialog(Function0<Unit> function0, ModalBottomSheetProperties properties, final Animatable<Float, AnimationVector1D> animatable, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2;
        Object value$iv$iv;
        int $dirty;
        Density density;
        Object value$iv;
        Object value$iv2;
        final Function0<Unit> function02 = function0;
        final ModalBottomSheetProperties modalBottomSheetProperties = properties;
        Composer $composer3 = $composer.startRestartGroup(1254951810);
        ComposerKt.sourceInformation($composer3, "C(ModalBottomSheetDialog)P(1,3,2)273@11822L7,274@11861L7,275@11916L7,276@11946L28,277@12001L29,278@12050L38,279@12105L24,280@12157L21,282@12204L697,305@12932L129,305@12907L154,314@13078L182,314@13067L193:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modalBottomSheetProperties) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ($changed & 512) == 0 ? $composer3.changed(animatable) : $composer3.changedInstance(animatable) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty2 & 1171) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1254951810, $dirty2, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:272)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            View view = (View) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density2 = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            CompositionContext composition = ComposablesKt.rememberCompositionContext($composer3, 0);
            final State currentContent$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer3, ($dirty2 >> 9) & 14);
            $composer2 = $composer3;
            UUID dialogId = (UUID) RememberSaveableKt.m3772rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialogId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, $composer3, 3072, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean darkThemeEnabled = DarkThemeKt.isSystemInDarkTheme($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1981517173, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(view) | $composer2.changed(density2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                $dirty = $dirty2;
                density = density2;
                function02 = function0;
                modalBottomSheetProperties = properties;
                ModalBottomSheetDialogWrapper $this$ModalBottomSheetDialog_u24lambda_u242_u24lambda_u241 = new ModalBottomSheetDialogWrapper(function02, modalBottomSheetProperties, view, layoutDirection, density, dialogId, animatable, scope, darkThemeEnabled);
                $this$ModalBottomSheetDialog_u24lambda_u242_u24lambda_u241.setContent(composition, ComposableLambdaKt.composableLambdaInstance(-1560960657, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1
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
                        ComposerKt.sourceInformation($composer4, "C296@12687L164:ModalBottomSheet.android.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1560960657, $changed2, -1, "androidx.compose.material3.ModalBottomSheetDialog.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:296)");
                            }
                            Modifier modifier$iv = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                    SemanticsPropertiesKt.dialog($this$semantics);
                                }
                            }, 1, null);
                            State<Function2<Composer, Integer, Unit>> state = currentContent$delegate;
                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i2 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -490070203, "C299@12809L16:ModalBottomSheet.android.kt#uh7d8r");
                            ModalBottomSheet_androidKt.ModalBottomSheetDialog$lambda$0(state).invoke($composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }));
                value$iv = $this$ModalBottomSheetDialog_u24lambda_u242_u24lambda_u241;
                $composer2.updateRememberedValue(value$iv);
            } else {
                $dirty = $dirty2;
                density = density2;
                value$iv = it$iv;
                function02 = function0;
                modalBottomSheetProperties = properties;
            }
            final ModalBottomSheetDialogWrapper dialog = (ModalBottomSheetDialogWrapper) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1981494445, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(dialog);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        dialog.show();
                        final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = dialog;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                modalBottomSheetDialogWrapper.dismiss();
                                modalBottomSheetDialogWrapper.disposeComposition();
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(dialog, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv3, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1981489720, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(dialog) | (($dirty & 14) == 4) | (($dirty & 112) == 32) | $composer2.changed(layoutDirection);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$2$1
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
                        dialog.updateParameters(function02, modalBottomSheetProperties, layoutDirection);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetDialog.3
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
                    ModalBottomSheet_androidKt.ModalBottomSheetDialog(function02, modalBottomSheetProperties, animatable, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        ViewGroup.LayoutParams layoutParams = $this$isFlagSecureEnabled.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowParams = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (windowParams == null || (windowParams.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy $this$shouldApplySecureFlag, boolean isSecureFlagSetOnParent) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shouldApplySecureFlag.ordinal()]) {
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return isSecureFlagSetOnParent;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
